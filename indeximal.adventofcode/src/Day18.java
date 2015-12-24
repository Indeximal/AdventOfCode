import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by cyrill on 06.12.15.
 */
public class Day18 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input18.txt";
        File inputFile = new File(inputFileName);
        Scanner s = new Scanner(inputFile);
        boolean[][] grid = new boolean[100][100];
        boolean[][] grid2 = new boolean[100][100];
        int lines = 0;
        while (s.hasNextLine()){
            String line = s.nextLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                grid[lines][i] = chars[i] == '#';
                grid2[lines][i] = chars[i] == '#';
            }
            lines++;
        }
        grid2[0][0] = true;
        grid2[0][99] = true;
        grid2[99][0] = true;
        grid2[99][99] = true;

        for (int i = 0; i < 100; i++) {
            boolean[][] newGrid = new boolean[100][100];
            boolean[][] newGrid2 = new boolean[100][100];
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    int numNeighbors = 0;
                    int numNeighbors2 = 0;
                    for (int x1 = x-1; x1 <= x+1; x1++) {
                        for (int y1 = y-1; y1 <= y+1; y1++) {
                            if (x1 == x && y1 == y){
                                continue;
                            }
                            try {
                                numNeighbors += grid[x1][y1] ? 1 : 0;
                                numNeighbors2 += grid2[x1][y1] ? 1 : 0;
                            } catch (IndexOutOfBoundsException e){
                            }
                        }
                    }

                    if (grid[x][y]){
                        if (numNeighbors == 2 || numNeighbors == 3){
                            newGrid[x][y] = true;
                        } else {
                            newGrid[x][y] = false;
                        }
                    } else {
                        if (numNeighbors == 3){
                            newGrid[x][y] = true;
                        } else {
                            newGrid[x][y] = false;
                        }
                    }
                    if (grid2[x][y]){
                        if (numNeighbors2 == 2 || numNeighbors2 == 3){
                            newGrid2[x][y] = true;
                        } else {
                            newGrid2[x][y] = false;
                        }
                    } else {
                        if (numNeighbors2 == 3){
                            newGrid2[x][y] = true;
                        } else {
                            newGrid2[x][y] = false;
                        }
                    }

                }
            }
            grid = newGrid;
            grid2 = newGrid2;
            grid2[0][0] = true;
            grid2[0][99] = true;
            grid2[99][0] = true;
            grid2[99][99] = true;
        }

        int lightsOn1 = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]){
                    lightsOn1++;
                }
            }
        }
        int lightsOn2 = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j]){
                    lightsOn2++;
                }
            }
        }
        System.out.printf("%d lights are on\n", lightsOn1);
        System.out.printf("The broken one has %d lights on\n", lightsOn2);
    }
}
