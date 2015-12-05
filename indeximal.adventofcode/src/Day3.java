import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cyrill on 03.12.15.
 */
public class Day3 {
    // Part 2
    public static void main(String[] args) {
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input3.txt";
        File inputFile = new File(inputFileName);
        ArrayList<int[]> housesVisited = new ArrayList<>();
        int posX = 0;
        int posY = 0;
        int[] posZero = {posX, posY};
        housesVisited.add(posZero);

        int roboPosX = 0;
        int roboPosY = 0;

        int chars = 0;
        try {
            Scanner scanner = new Scanner(inputFile);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.next());
            }
            String input = sb.toString();
            char[] directions = input.toCharArray();
            for (int i = 0; i < directions.length; i++) {
                int[] pos = new int[2];
                if (i % 2 == 0){
                    if(directions[i] == '^'){
                        posY++;
                    } else if (directions[i] == 'v'){
                        posY--;
                    } else if (directions[i] == '<') {
                        posX--;
                    } else if (directions[i] == '>'){
                        posX++;
                    }
                    pos[0] = posX;
                    pos[1] = posY;
                } else {
                    if(directions[i] == '^'){
                        roboPosX++;
                    } else if (directions[i] == 'v'){
                        roboPosY--;
                    } else if (directions[i] == '<') {
                        roboPosX--;
                    } else if (directions[i] == '>'){
                        roboPosX++;
                    }
                    pos[0] = roboPosX;
                    pos[1] = roboPosY;
                }
                boolean existed = false;
                for (int j = 0; j < housesVisited.size(); j++) {
                    if (housesVisited.get(j)[0] == pos[0] && housesVisited.get(j)[1] == pos[1]){
                        existed = true;
                        break;
                    }
                }
                if (!existed){
                    housesVisited.add(pos);
                }
                chars++;


            }
            System.out.println("Houses Visited: "+ housesVisited.size() +" presents: " + chars);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
