#!/usr/bin/env python3

import sys
from matplotlib import pyplot as plt

def main():
    runs = int(sys.argv[2])
    size = 100
    try:
        start = float(sys.argv[3])
        end = float(sys.argv[4])
        size = int(sys.argv[5])
        _f = open("ProbabilityPercolationCurve(Size"+str(size)+")(Runs"+str(runs)+")(Difference"+sys.argv[1]+")(Start"+str(start)+")(End"+str(end)+").txt")
    except IndexError:
        _f = open("ProbabilityPercolationCurve(Size"+str(size)+")(Runs"+str(runs)+")(Difference"+sys.argv[1]+").txt")
    _f.readline()
    _f.readline()
    _x = []
    _y = []
    for line in _f:
        try:
            _l = list(map(float, line.rstrip('\n').split()))
            _x.append(_l[0])
            _y.append(_l[-1])
        except:
            break
    plt.suptitle('Runs = '+str(runs)+" _ Size = "+str(size), fontsize=15)
    plt.xlabel('Probability of Openings', fontsize=9)
    plt.ylabel('Probability of Percolation', fontsize=8)
    plt.plot(_x, _y)
    plt.show()

if __name__ == '__main__':
    main()
