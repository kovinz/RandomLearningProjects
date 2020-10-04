import math

def methodDihotomii(f, a, b, eps):
    mid = (b + a) / 2
    x1 = mid - eps / 3
    x2 = mid + eps / 3
    counter = 0
    while abs(b - a) > eps:
        mid = (b + a) / 2
        x1 = mid - eps / 3
        x2 = mid + eps / 3
        f1 = f(x1)
        f2 = f(x2)
        counter += 1
        print("Начало: {} Конец: {} Расстояние: {}".format(a, b, (b-a)))
        print("x1: {} x2: {}".format(x1, x2))
        print("Значение функции в x1: {} Значение функции в x2: {}\n".format(f1, f2))
        if f1 < f2:
            b = x2
        elif f2 < f1:
            a = x1
        else:
            a = x1
            b = x2
    print("Поиск минимума сделан за количество шагов: {}".format(counter))
    return (x1 + x2) / 2


def methodGoldenRatio(f, a, b, eps):
    x1 = a + 0.381966011 * (b - a)
    x2 = a + 0.618003399 * (b - a)
    counter = 0
    while abs(b - a) > eps:
        x1 = a + 0.381966011 * (b - a)
        x2 = a + 0.618003399 * (b - a)
        f1 = f(x1)
        f2 = f(x2)
        counter += 1
        print("Начало: {} Конец: {} Расстояние: {}".format(a, b, (b - a)))
        print("x1: {} x2: {}".format(x1, x2))
        print("Значение функции в x1: {} Значение функции в x2: {}\n".format(f1, f2))
        if f1 < f2:
            b = x2
        elif f2 < f1:
            a = x1
        else:
            a = x1
            b = x2
    print("Поиск минимума сделан за количество шагов: {}".format(counter))
    return (x1 + x2) / 2


def newFibonachi(l: list):
    n = len(l)
    newF = (((1 + math.sqrt(5)) / 2) ** n) / math.sqrt(5)
    l.append(newF)


def methodFibonachi(f, a, b, eps):
    F = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144]
    toFindF2 = (b - a) / eps
    i = 2
    while toFindF2 >= F[i]:
        if len(F) - 1 == i:
            newFibonachi(F)
        i += 1
    fib0 = F[i - 2]
    fib1 = F[i - 1]
    fib2 = F[i]
    x1 = a + fib0 / fib2 * (b - a)
    x2 = a + fib1 / fib2 * (b - a)
    counter = 0
    while abs(b - a) > eps:
        x1 = a + fib0 / fib2 * (b - a)
        x2 = a + fib1 / fib2 * (b - a)
        f1 = f(x1)
        f2 = f(x2)
        counter += 1
        print("Начало: {} Конец: {} Расстояние: {}".format(a, b, (b - a)))
        print("x1: {} x2: {}".format(x1, x2))
        print("Значение функции в x1: {} Значение функции в x2: {}\n".format(f1, f2))
        if f1 < f2:
            b = x2
        elif f2 < f1:
            a = x1
        else:
            a = x1
            b = x2
    print("Поиск минимума сделан за количество шагов: {}".format(counter))
    return (x1 + x2) / 2


def f(x: float) -> float:
    return (x - 2) ** 2


if __name__ == '__main__':
    eps = 0.1
    a = -2
    b = 20
    print(methodDihotomii(f, a, b, eps))
    print(methodGoldenRatio(f, a, b, eps))
    print(methodFibonachi(f, a, b, eps))
