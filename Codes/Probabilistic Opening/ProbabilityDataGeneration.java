import java.io.FileOutputStream;
import java.io.File;

public class ProbabilityDataGeneration {
    //GENERATING DATA
    public static void main(String[] args) {
        Double diff = Double.parseDouble(args[0]);
        int trials = Integer.parseInt(args[1]), size;
        double start, end;
        File f;
        try {
            size = Integer.parseInt(args[4]);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            size = 100;
        }
        try {
            start = Double.parseDouble(args[2]);
            end = Double.parseDouble(args[3]);
            f = new File("../../Data/Probabilistic/ProbabilityPercolationCurve(Size"+size+")(Runs"+trials+")(Difference"+diff.toString()+")(Start"+start+")(End"+end+").txt");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            start = 0.0;
            end = 1.0;
            f = new File("../../Data/Probabilistic/ProbabilityPercolationCurve(Size"+size+")(Runs"+trials+")(Difference"+diff.toString()+").txt");
        }
        try {
            if(!f.exists())
                f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(("Runs :"+trials+"\nDifference : "+diff+"\n").getBytes());
            for(double p = start; p<=end; p+=diff) {
                System.out.println(String.format("%g", p));
                int count = 0;
                for(int i=0; i<trials; i++) {
                    PercolationVariedProbability per = new PercolationVariedProbability(size);
                    for(int k=per.size()-1; k>=0; k--) {
                        for(int j=0; j<per.size(); j++)
                            if(per.randomBoolean(p))
                                per.open(j, k);
                        if(per.lowestFilledLevel() != k)
                            break;
                    }
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
