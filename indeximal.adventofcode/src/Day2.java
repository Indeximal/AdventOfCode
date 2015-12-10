import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by cyrill on 03.12.15.
 */
public class Day2 {
    public static void main(String[] args){
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input2.txt";
        File inputFile = new File(inputFileName);
        int sqftNeeded = 0;
        int ftNeeded = 0;
        int lines = 0;
        try {
            Scanner in = new Scanner(inputFile);
            while (in.hasNextLine()){
                String line = in.nextLine();
                String[] nums = line.split("x");
                int l = Integer.parseInt(nums[0]);
                int w = Integer.parseInt(nums[1]);
                int h = Integer.parseInt(nums[2]);

                int a1 = l*w;
                int a2 = l*h;
                int a3 = w*h;
                int over = Math.min(a1, Math.min(a2, a3));
                sqftNeeded += 2 * a1 + 2 * a2 + 2 * a3 + over;

                int ribbonUsed = 2*l + 2*w + 2*h -  2*Math.max(l, Math.max(w, h));
                ftNeeded += ribbonUsed + l*w*h;

                lines++;
            }
            System.out.println(sqftNeeded+" sqft of paper and " + ftNeeded +" ft of ribbon needed for "+lines+" packets");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
