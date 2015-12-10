import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by cyrill on 06.12.15.
 */
public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input6.txt";
        File inputFile = new File(inputFileName);
        Scanner s = new Scanner(inputFile);

        int instructionsFollowed = 0;
        boolean[][] grid = new boolean[1000][1000];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = false;
            }
        }
        int[][] intGrid = new int[1000][1000];

        for (int i = 0; i < intGrid.length; i++) {
            for (int j = 0; j < intGrid[i].length; j++) {
                intGrid[i][j] = 0;
            }
        }

        while (s.hasNextLine()){
            String instruction = s.nextLine();
            String coords = instruction.replace(" through ", ",").replace("turn off ", "").replace("turn on ", "").replace("toggle ", "");
            String[] nums = coords.split(",");
            int minX = Integer.parseInt(nums[0]);
            int minY = Integer.parseInt(nums[1]);
            int maxX = Integer.parseInt(nums[2]);
            int maxY = Integer.parseInt(nums[3]);

            if (instruction.startsWith("turn off ")){
                for (int i = minX; i <= maxX; i++){
                    for (int j = minY; j <= maxY; j++) {
                        grid[i][j] = false;
                        if (intGrid[i][j] > 0){
                            intGrid[i][j] -= 1;
                        }
                    }
                }
            } else if (instruction.startsWith("turn on ")){
                for (int i = minX; i <= maxX; i++){
                    for (int j = minY; j <= maxY; j++) {
                        grid[i][j] = true;
                        intGrid[i][j] += 1;
                    }
                }
            } else if (instruction.startsWith("toggle ")){
                for (int i = minX; i <= maxX; i++){
                    for (int j = minY; j <= maxY; j++) {
                        grid[i][j] = !grid[i][j];
                        intGrid[i][j] += 2;
                    }
                }
            }

            instructionsFollowed++;
        }
        int lightsOn = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == true){
                    lightsOn++;
                }
            }
        }
        int totalBrightness = 0;
        for (int i = 0; i < intGrid.length; i++) {
            for (int j = 0; j < intGrid[i].length; j++) {
                totalBrightness += intGrid[i][j];
            }
        }
        System.out.printf("%d lights are on after %d instructions\n",lightsOn, instructionsFollowed);
        System.out.printf("With a total brightness of %d\n", totalBrightness);
    }
}
