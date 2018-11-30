import edu.princeton.cs.algs4.*;
import java.util.Random;

public class PercolationVariedProbability {
    private int size, open_count;
    private Site[][] sites;
    private boolean percolates;
    public Random r = new Random();

    public PercolationVariedProbability(int size) {
        this.size = size;
        this.open_count = 0;
        this.percolates = false;
        this.sites = new Site[size][size];
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                sites[i][j] = new Site();
    }

    public int size() {
        return size;
    }

    public int openCount() {
        return this.open_count;
    }

    public void open(int i, int j) {
        if(i<0 || i>=size || j<0 || j>=size) {
            System.out.println("Invalid Index.");
            return;
        }
        if(!isOpen(i, j)) {
            open_count++;
            sites[i][j].open();
            if(j == size-1)
                fill(i, j);
            if(isFull(i, j-1) || isFull(i, j+1) || isFull(i-1, j) || isFull(i+1, j))
                fill(i, j);
        }
    }

    public void fill(int i, int j) {
        if(i<0 || i>=size || j<0 || j>=size) {
            System.out.println("Invalid Index.");
            return;
        }
        sites[i][j].fill();
        if(j == 0)
            this.percolates = true;
        if(isOpen(i, j-1) && !isFull(i, j-1))
            fill(i, j-1);
        if(isOpen(i, j+1) && !isFull(i, j+1))
            fill(i, j+1);
        if(isOpen(i-1, j) && !isFull(i-1, j))
            fill(i-1, j);
        if(isOpen(i+1, j) && !isFull(i+1, j))
            fill(i+1, j);
    }

    public boolean isOpen(int i, int j) {
        if(i<0 || i>=size || j<0 || j>=size)
            return false;
        return sites[i][j].isOpen();
    }

    public boolean isFull(int i, int j) {
        if(i<0 || i>=size || j<0 || j>=size)
            return false;
        return sites[i][j].isFull();
    }

    public boolean percolates() {
        return percolates;
    }

    public boolean randomBoolean(double p) {
        // RETURN TRUE WITH PROBABILITY p
        assert(p<1 && p>0): "Probability not in range.";
        int a = (int)(10000/p);
        return r.nextInt(a)<10000;
    }
}
