#!/usr/bin/env python3

import sys
from math import sqrt
from matplotlib import pyplot as plt

def deviation(y, mean):
    variance = 0
    for val in y:
        variance += pow(mean-val, 2)
    variance = variance/len(y)
    return sqrt(variance)

def main():
    init_size = int(sys.argv[1])
    final_size = int(sys.argv[2])
    step = int(sys.argv[3])
    runs = int(sys.argv[4])
    _f = open("ProbabilityEstimation_Start_"+sys.argv[1]+"_End_"+sys.argv[2]+"_Step_"+sys.argv[3]+"_Runs_"+sys.argv[4]+".txt")
    size = init_size
    _x = []
    _y = []
    _f.readline()
    while size <= final_size:
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
    std_dev = deviation(_y, val/len(_x))
    plt.suptitle('Runs = '+str(runs), fontsize=15)
    plt.xlabel('Size of grids', fontsize=9)
    plt.ylabel('Probable openings', fontsize=8)
    plt.text((init_size+final_size)//2, val/len(_x)+std_dev, "Mean = "+str(val/len(_x))+"\nStd. Dev. = "+str(std_dev), fontsize=7.5)
    plt.plot(_x, [val/len(_x)]*len(_x))
    plt.plot(_x, _y)
    plt.show()

if __name__ == '__main__':
    main()
