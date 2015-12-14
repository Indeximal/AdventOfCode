import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by cyrill on 14.12.15.
 */
public class Day12 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input12.txt";
        File inputFile = new File(inputFileName);
        Scanner scanner = new Scanner(inputFile);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            sb.append(scanner.next());
        }
        String input = sb.toString();
        char[] chars = input.toCharArray();
        boolean inQuotes = false;

        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!inQuotes) {
                int now = 0;
                int negative = 1;
                int k = i;
                if (chars[i] == '-') {
                    negative = -1;
                    k++;
                }
                while (chars[k] <= '9' && chars[k] >= '0') {
                    now *= 10;
                    now += chars[k] - '0';
                    k++;
                }
                i = k;
                total += now * negative;
            }
            if (chars[i] == '"'){
                inQuotes = !inQuotes;
            }

        }
        System.out.printf("A total of %d was found in the JSON", total);
    }
}
