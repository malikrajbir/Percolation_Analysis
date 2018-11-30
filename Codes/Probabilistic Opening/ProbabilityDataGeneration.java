import java.util.Random;
import java.io.FileOutputStream;
import java.io.File;

public class ProbabilityDataGeneration {
    //GENERATING DATA
    public static void main(String[] args) {
        Random r = new Random();
        Double diff = Double.parseDouble(args[0]);
        int trials = Integer.parseInt(args[1]), size=100;
        double start, end;
        File f;
        try {
            start = Double.parseDouble(args[2]);
            end = Double.parseDouble(args[3]);
            f = new File("../../Data/Probabilistic/ProbabilityPercolationCurve("+trials+")("+diff.toString()+")("+start+")("+end+").txt");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            start = 0.0;
            end = 1.0;
            f = new File("../../Data/Probabilistic/ProbabilityPercolationCurve("+trials+")("+diff.toString()+").txt");
        }
        try {
            size = Integer.parseInt(args[4]);
        }
        catch(ArrayIndexOutOfBoundsException e) {}
        try {
            if(!f.exists())
                f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(("Runs :"+trials+"\nDifference : "+diff+"\n").getBytes());
            for(double p = start; p<=end; p+=diff) {
                System.out.println(String.format("%g", p));
                int count = 0;
                for(int i=0; i<trials; i++) {
                    PercolationVariedProbability per = new PercolationVariedProbability(size+r.nextInt(50));
                    for(int k=0; k<per.size(); k++)
                        for(int j=0; j<per.size(); j++)
                            if(per.randomBoolean(p))
                                per.open(k, j);
                    if(per.percolates())
                        count++;
                }
                fos.write((String.format("%g ", p)+trials+" "+count+" "+count/(float)trials+"\n").getBytes());
            }
            fos.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
