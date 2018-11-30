#!/usr/bin/env python3

import sys
from matplotlib import pyplot as plt

def main():
    finalsize = int(sys.argv[1])
    step = int(sys.argv[2])
    runs = int(sys.argv[3])
    _f = open("ProbabilityEstimation_"+str(finalsize)+"_"+str(step)+"_"+str(runs)+".txt")
    size = 50
    _x = []
    _y = []
    _f.readline()
    while size <= finalsize:
        _f.readline()
        _x.append(size)
        val = 0
        for _ in range(runs):
            val += float(_f.readline().split()[-1])
        _y.append(val/runs)
        _f.readline()
        size += step
    val = 0
    for value in _y:
        val += value
    plt.plot(_x, [val/len(_x)]*len(_x))
    plt.plot(_x, _y)
    plt.show()

if __name__ == '__main__':
    main()
