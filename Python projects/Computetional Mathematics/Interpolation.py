import numpy as np
import matplotlib.pyplot as plt


def lagranz(x, y, t):
    answer = 0
    for j in range(len(y)):
        p1 = 1
        p2 = 1
        for i in range(len(x)):
            if i == j:
                p1 = p1 * 1
                p2 = p2 * 1
            else:
                p1 = p1 * (t - x[i])
                p2 = p2 * (x[j] - x[i])
        answer += y[j] * p1 / p2
    return answer


if __name__ == '__main__':
    x = np.array([0.119, 0.718, 1.342, 2.859, 3.948], dtype=float)
    y = np.array([-0.572, -2.015, -3.342, -6.752, -6.742], dtype=float)
    xnew = np.linspace(np.min(x), np.max(x), 100)
    ynew = [lagranz(x, y, i) for i in xnew]
    plt.plot(x, y, 'o', xnew, ynew, color='red')
    plt.plot(x, y, color='black', linestyle='dashed')
    plt.grid(True)
    plt.show()
