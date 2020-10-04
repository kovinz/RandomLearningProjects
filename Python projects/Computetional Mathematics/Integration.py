import math
import numpy as np


def trapezoidalMethod(f, a, b, n):
    result = (f(a) + f(b)) / 2
    h = (b - a) / n
    for x in np.arange(a + h, b, h):
        result += f(x)
    result *= h
    return result


def simpsonMethod(f, a, b, n):
    h = (b - a) / n
    result = f(a) + f(b)
    for x in np.arange(a + h, b, 2*h):
        result += 4*f(x)
    for x in np.arange(a + 2*h, b, 2*h):
        result += 2*f(x)
    result *= h/3
    return result


def newtonLebnicMethod(f, a, b):
    return f(b) - f(a)


if __name__ == '__main__':
    f = lambda x: x * math.cos(2*x)
    fNew = lambda x: x/2 * math.sin(2*x) + 1/4 * math.cos(2*x)
    a = 0
    b = 1
    n = 50
    trapAns = trapezoidalMethod(f, a, b, n)
    simAns = simpsonMethod(f, a, b, n)
    newAns = newtonLebnicMethod(fNew, a, b)
    print(trapAns)
    print(simAns)
    print(newAns)
