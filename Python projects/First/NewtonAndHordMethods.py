import matplotlib.pyplot as plt
import math
import numpy as np


def newtonMethod(f, f1, f2, a, b):
    try:
        if any(i == 0 for i in yPrime[a:b]) or \
                any(i >= 0 for i in yDoublePrime[a:b]) and any(i < 0 for i in yDoublePrime[a:b]):
            return False

        x0 = (a + b) // 2
        if f2(x0) * f(x0) < 0:
            if f2(x0) < 0:
                for i in range(x0 + 1, b):
                    if f2(i) * f(i) > 0:
                        x0 = i
                        break
            else:
                for i in reversed(range(a, x0 - 1)):
                    if f2(i) * f(i) > 0:
                        x0 = i
                        break

        xn = x0
        xn1 = xn - f(xn) / f1(xn)
        while abs(xn1 - xn) > math.pow(10, -3):
            xn = xn1
            xn1 = xn - f(xn) / f1(xn)
        return xn1
    except ZeroDivisionError:
        print("Zero division")


def hordMethod(f, f1, a, b):
    try:
        if any(i == 0 for i in yPrime[a:b]) or \
                any(i >= 0 for i in yDoublePrime[a:b]) and any(i < 0 for i in yDoublePrime[a:b]):
            return False

        eps = math.pow(10, -3)
        x = (b + a) / 2
        x_prev = x + 2 * eps
        while abs(x - x_prev) >= eps:
            x, x_prev = x - f(x) / (f(x) - f(x_prev)) * (x - x_prev), x
        return x
    except ZeroDivisionError:
        print("Zero division")


if __name__ == '__main__':
    def f(x: float) -> float:
        return math.exp(-0.7 * x) - 0.3 * math.sqrt(x) + 1


    def f1(x: float) -> float:
        return -0.7 * math.exp(-0.7 * x) - 0.15 / math.sqrt(x)


    def f2(x: float) -> float:
        return 49 / 100 * math.exp(-0.7 * x) + 3 / (40 * math.pow(x, 3 / 2))

    xArray = np.array(range(1, 100))
    yArray = np.array([f(x) for x in xArray])
    yPrime = np.diff(yArray)
    yDoublePrime = np.diff(yPrime)

    print(newtonMethod(f, f1, f2, 1, 50))
    print(hordMethod(f, f1, 1, 50))
    plt.scatter(xArray, yArray)
    plt.show()
