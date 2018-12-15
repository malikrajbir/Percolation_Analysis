import java.util.Random;
import java.io.FileOutputStream;
import java.io.File;

public class DataGeneration {
    //GENERATING DATA
    public static void main(String[] args) {
        Random r = new Random();
        try {
            int runs = Integer.parseInt(args[2]);
            int finalSize = Integer.parseInt(args[1]);
            int initSize = Integer.parseInt(args[0]);
            int step = Integer.parseInt(args[2]);
            File f = new File("../../Data/Random/ProbabilityEstimation_Start_"+initSize+"_End_"+finalSize+"_Step_"+step+"_Runs_"+runs+".txt");
            if(!f.exists())
                f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(("Runs: "+runs).getBytes());
            for(int size = initSize; size<=finalSize; size+=step) {
                fos.write(("\nSize : "+size+"\n").getBytes());
                for(int i=0; i<runs; i++) {
                    PercolationNonVisual p = new PercolationNonVisual(size);
                    while(!p.percolates()) {
                        p.open(r.nextInt(p.size()), r.nextInt(p.size()));
                    }
                    fos.write((p.size()+" "+p.openCount()+" "+((float)p.openCount()/(p.size()*p.size()))+"\n").getBytes());
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
