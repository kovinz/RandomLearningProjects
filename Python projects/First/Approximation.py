import numpy as np
import matplotlib.pyplot as plt
import math

x = np.array([0.173, 0.518, 0.864, 1.209, 1.555, 1.901, 2.246, 2.592, 2.937], dtype=float)
y = np.array([-1.547, -0.852, 0.063, -0.470, -0.750, -1.142, -1.052, -1.188, -0.962], dtype=float)

'''(y - (a * sqrt(x) + b * sin(x) + c)) ^ 2

2 * (y - (a * sqrt(x) + b * sin(x) + c)) * sqrt(x) = 0
2 * (y - (a * sqrt(x) + b * sin(x) + c)) * sin(x) = 0
2 * (y - (a * sqrt(x) + b * sin(x) + c)) = 0

2*y*sqrt(x) - 2*x*a - 2*sin(x)*sqrt(x)*b - 2*sqrt(x)*c = 0
2*y*sin(x) - 2*sqrt(x)*sin(x)*a - 2*sin^2(x)*b - 2*sin(x)*c = 0
2*y - 2*sqrt(x)*a - 2*sin(x)*b - 2*c = 0

2*x*a + 2*sin(x)*sqrt(x)*b + 2*sqrt(x)*c = 2*y*sqrt(x)
2*sqrt(x)*sin(x)*a + 2*sin^2(x)*b + 2*sin(x)*c = 2*y*sin(x)
2*sqrt(x)*a + 2*sin(x)*b + 2*c = 2*y'''

sqrtX = np.sqrt(x)
sinX = np.sin(x)

sumX = np.sum(x)
sumSinSqrtX = np.sum(sqrtX * sinX)
sumSqrtX = np.sum(sqrtX)
sumYSqrtX = np.sum(y * sqrtX)
sumSinSecondDegreeX = np.sum(sinX * sinX)
sumSinX = np.sum(sinX)
sumYSinX = np.sum(y * sinX)
sumY = np.sum(y)

matrixA = np.array([[2*sumX, 2*sumSinSqrtX, 2*sumSqrtX],
                    [2*sumSinSqrtX, 2*sumSinSecondDegreeX, sumSinX],
                    [2*sumSqrtX, 2*sumSinX, 2.0]], dtype=float)
matrixB = np.array([2*sumYSqrtX, 2*sumYSinX, 2*sumY], dtype=float)


answer = np.linalg.solve(matrixA, matrixB)
print(answer)

xnew = np.linspace(np.min(x), np.max(x), 100)
ynew = [-1.0706749 * math.sqrt(x) + 0.56973596 * math.sin(x) + 0.14997273 for x in xnew]

plt.plot(x, y, 'o', xnew, ynew, color='red')
plt.grid(True)
plt.show()
