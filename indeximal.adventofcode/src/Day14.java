import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cyrill on 14.12.15.
 */
public class Day14 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input14.txt";
        File inputFile = new File(inputFileName);
        Scanner scanner = new Scanner(inputFile);
        ArrayList<int[]> reindeer = new ArrayList<>();
        //0: lengthTravelled, 1: travelSpeed, 2: travelTime, 3: stayTime, 4: score
        int secondsUntilFinish = 2503;
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String toSplit = str.replace(" can fly ", ",").replace(" km/s for ", ",").replace(" seconds, but then must rest for ", ",").replace(" seconds.",",");
            String[] data = toSplit.split(",");
            int[] dataArray = {0, Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), 0};
            reindeer.add(dataArray);
        }
        for (int j = 1; j <= secondsUntilFinish; j++) {
            int[] best = {0};
            for (int i = 0; i < reindeer.size(); i++) {
                int[] r = reindeer.get(i);

                int over = j % (r[2] + r[3]);
                int times = j / (r[2] + r[3]);
                int length = times * r[1] * r[2];
                int overLength = Math.min(r[1] * r[2], over * r[1]);
                r[0] = length + overLength;
                if (length + overLength > best[0]) {
                    best = r;
                }
            }
            best[4]++;

        }
        int bestLength = 0;
        int bestPoints = 0;
        for (int i = 0; i < reindeer.size(); i++) {
            if (reindeer.get(i)[0] > bestLength){
                bestLength = reindeer.get(i)[0];
            }
            if (reindeer.get(i)[4] > bestPoints){
                bestPoints = reindeer.get(i)[4];
            }
        }
        System.out.printf("Furthest reindeer travelled %d km but best reindeer scored %d points after %d seconds\n", bestLength, bestPoints, secondsUntilFinish);



    }
}
