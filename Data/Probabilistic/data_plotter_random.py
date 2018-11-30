#!/usr/bin/env python3

import sys
from matplotlib import pyplot as plt

def main():
    runs = int(sys.argv[2])
    diff = float(sys.argv[1])
    try:
        start = float(sys.argv[3])
        end = float(sys.argv[4])
        _f = open("ProbabilityPercolationCurve("+str(runs)+")("+str(diff)+")("+str(start)+")("+str(end)+").txt")
    except:
        _f = open("ProbabilityPercolationCurve("+str(runs)+")("+str(diff)+").txt")
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
    plt.plot(_x, _y)
    plt.show()

if __name__ == '__main__':
    main()
