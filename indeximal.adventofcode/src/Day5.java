import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by cyrill on 05.12.15.
 */
public class Day5 {
    private static boolean testing = false;

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input5.txt";
        File inputFile = new File(inputFileName);
        Scanner s = new Scanner(inputFile);
        int nice = 0;
        int newNice = 0;
        int wordsChecked = 0;
        while (s.hasNext()){
            String input = s.next();
            char[] chars = input.toCharArray();
            int numVowels = 0;
            boolean hasDouble = false;
            boolean hasRepeat = false;
            boolean hasTwoSames = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'){
                    numVowels++;
                }
                if (i > 0){
                    if (chars[i] == chars[i-1]){
                        hasDouble = true;
                    }
                }
                if (i > 1){
                    if (chars[i] == chars[i-2]){
                        hasRepeat = true;
                    }
                }
                if (i >= 3){
                    for (int j = i-2; j > 0; j--) {
                        if (chars[j] == chars[i] && chars[j-1] == chars[i-1]){
                            hasTwoSames = true;
                        }
                    }
                }
            }
            if (!(numVowels < 3 || !hasDouble || input.contains("xy") || input.contains("ab") || input.contains("cd") || input.contains("pq"))){
                nice++;
            }
            if (hasRepeat && hasTwoSames){
                newNice++;
            }

            wordsChecked++;
            if (newNice > 0 && testing){
                break;
            }
        }
        System.out.printf("%d words pretend to be nice in total %d words\n", nice, wordsChecked);
        System.out.printf("But only %d words are really nice\n", newNice);
    }
}
