import math
import matplotlib.pyplot as plt


def eilerMethod(f, a, b, n, y0):
    h = (b - a) / n
    xlist = [(a + h * i) for i in range(n)]
    ylist = []
    prev = y0
    for x in xlist:
        y = prev + h * f(x, prev)
        ylist.append(y)
        prev = y
    return xlist, ylist


def rungeKuttiMethod(f, a, b, n, y0):
    h = (b - a) / n
    xlist = [(a + h * i) for i in range(n)]
    ylist = []
    prev = y0
    for x in xlist:
        k1 = f(x, prev)
        k2 = f(x + h / 2, prev + h / 2 * k1)
        k3 = f(x + h / 2, prev + h / 2 * k2)
        k4 = f(x + h, prev + h * k3)
        y = prev + h/6 * (k1 + 2*k2 + 2*k3 + k4)
        ylist.append(y)
        prev = y
    return xlist, ylist


if __name__ == '__main__':
    f = lambda x, y: 0.5 * x * y**2
    a = 0
    b = 1
    y0 = 1
    n = 100
    xlist, ylist = eilerMethod(f, a, b, n, y0)
    xlist2, ylist2 = rungeKuttiMethod(f, a, b, n, y0)
    plt.plot(xlist, ylist, color="blue")
    plt.plot(xlist2, ylist2, color="red")
    plt.grid()
    plt.show()
