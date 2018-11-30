import edu.princeton.cs.algs4.*;

public class Site {
    private boolean open, filled;

    public Site() {
        this.open = false;
        this.filled = false;
    }

    public void open() {
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }

    public boolean isFull() {
        return this.filled;
    }

    public void fill() {
        try {
            assert(open):"Site is blocked. First open it.";
            this.filled = true;
        }
        catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public void draw(int x, int y) {
        if(filled)
            StdDraw.setPenColor(StdDraw.BLUE);
        else if(open)
            StdDraw.setPenColor(StdDraw.WHITE);
        else
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.filledSquare(x+0.5, y+0.5, 0.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x+0.5, y+0.5, 0.5);
    }
}
