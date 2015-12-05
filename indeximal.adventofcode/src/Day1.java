import jdk.internal.util.xml.impl.ReaderUTF8;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Indeximal on 03.12.15.
 */
public class Day1 {
    // Part 1 and 2
    public static void main(String[] args){
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input1.txt";
        File inputFile = new File(inputFileName);
        int total = 0;
        int numchars = 0;
        int firstBasementEntry = -1;
        try {
            Scanner scanner = new Scanner(inputFile);
            String input = "";
            while (scanner.hasNext()) {
                input += scanner.next();
            }
            char[] chars = input.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '(') {
                    total++;
                } else if (c == ')'){
                    total--;
                }
                if (total < 0 && firstBasementEntry == -1) {
                    firstBasementEntry = i + 1;
                }
                numchars++;
            }

            System.out.println(total + " in " + numchars + " chars");
            System.out.println("First Basement Entry: " + firstBasementEntry);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
