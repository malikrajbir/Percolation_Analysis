import edu.princeton.cs.algs4.*;

public class PercolationNonVisual {
    private int size, open_count;
    private Site[][] sites;
    private boolean percolates;

    public PercolationNonVisual(int size) {
        this.size = size;
        this.open_count = 0;
        this.percolates = false;
        this.sites = new Site[size][size];
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                this.sites[i][j] = new Site();
    }

    public int size() {
        return this.size;
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
}
