import matplotlib.pyplot as plt
import math
import numpy as np


def newtonMethod(f1, f2, x0, y0):
    eps = math.pow(10, -3)
    try:
        xn = x0
        xn1 = xn - f2(xn) / f1(xn)
        while abs(xn1 - xn) > eps:
            xn = xn1
            xn1 = xn - f2(xn) / f1(xn)
        return xn1
    except ZeroDivisionError:
        print("Zero division")


if __name__ == '__main__':
    def f1(x1: float, x2: float) -> float:
        return math.sin(x1) + 2 * x2 - 2

    def f2(x1: float, x2: float) -> float:
        return math.cos(x1) + x2 - 1.5

    def f1Difx1(x1: float, x2: float) -> float:
        return math.cos(x1)

    def f1Difx2(x1: float, x2: float) -> float:
        return 2

    def f2Difx1(x1: float, x2: float) -> float:
        return -math.sin(x1)

    def f2Difx2(x1: float, x2: float) -> float:
        return 1

    def f1ForGraph(x1: float) -> float:
        return (2 - math.sin(x1)) / 2

    def f2ForGraph(x1: float) -> float:
        return 1.5 - math.cos(x1)

    x1Array = np.linspace(-2, 2, 100)
    x2Array1 = np.array([f1ForGraph(x1) for x1 in x1Array])
    x2Array2 = np.array([f2ForGraph(x1) for x1 in x1Array])
    plt.scatter(x1Array, x2Array1, color="red")
    plt.scatter(x1Array, x2Array2, color="blue")
    plt.show()

    # print(newtonMethod(f, f1, f2, 1, 50))
