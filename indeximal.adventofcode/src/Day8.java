import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input8.txt");
        Scanner s = new Scanner(f);
        int totalInCode = 0;
        int totalChars = 0;
        int totalEncoded = 0;
        while (s.hasNextLine()) {
            String str = s.nextLine();
            totalInCode += str.length();
            char[] chars = str.toCharArray();
            int unusedChars = 0;
            int extraChars = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '\\') {
                    if (chars[i + 1] == '"') {
                        unusedChars++;
                        i++;
                    } else if (chars[i + 1] == '\\') {
                        unusedChars++;
                        i++;
                    } else if (chars[i + 1] == 'x') {
                        unusedChars += 3;
                        i += 3;
                    }
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '"') {
                    extraChars++;
                } else if (chars[i] == '\\') {
                    extraChars++;
                }
            }
            totalEncoded += str.length() + extraChars + 2;
            totalChars += str.length() - unusedChars - 2;
        }
        System.out.printf("%d chars in code but only %d in the memory for a difference of %d\n", totalInCode, totalChars, totalInCode - totalChars);
        System.out.printf("%d encoded chars for a difference of %d\n", totalEncoded, totalEncoded - totalInCode);
    }
}
