import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * Created by cyrill on 10.12.15.
 */
public class Day7 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "/Volumes/Terra Disk/Cyrill/Programmierung/Git Hub/Advent of Code/input7.txt";
        File inputFile = new File(inputFileName);
        Scanner s = new Scanner(inputFile);
        HashMap<String, Short> wires = new HashMap<>();
        int instructionsFollowed = 0;

        while (s.hasNextLine()){
            String str = s.nextLine();
            String[] insts = str.split(" -> ");
            String in = insts[0];
            String out = insts[1];
            if (in.contains("AND")){
                String[] ins = in.split(" AND ");
                String in1 = ins[0];
                String in2 = ins[1];
                short inShort1;
                short inShort2;
                try {
                    inShort1 = Short.parseShort(in1);
                } catch (NumberFormatException ex){
                    inShort1 = wires.getOrDefault(in1, (short) 0);
                }
                try {
                    inShort2 = Short.parseShort(in2);
                } catch (NumberFormatException ex){
                    inShort2 = wires.getOrDefault(in2, (short) 0);
                }
                wires.put(out, (short) (inShort1 & inShort2));
            } else if (in.contains("OR")){
                String[] ins = in.split(" OR ");
                String in1 = ins[0];
                String in2 = ins[1];
                short inShort1;
                short inShort2;
                try {
                    inShort1 = Short.parseShort(in1);
                } catch (NumberFormatException ex){
                    inShort1 = wires.getOrDefault(in1, (short) 0);
                }
                try {
                    inShort2 = Short.parseShort(in2);
                } catch (NumberFormatException ex){
                    inShort2 = wires.getOrDefault(in2, (short) 0);
                }
                wires.put(out, (short) (inShort1 | inShort2));
            } else if (in.contains("LSHIFT")){
                String[] ins = in.split(" LSHIFT ");
                String in1 = ins[0];
                String in2 = ins[1];
                short inShort1;
                short inShort2;
                try {
                    inShort1 = Short.parseShort(in1);
                } catch (NumberFormatException ex){
                    inShort1 = wires.getOrDefault(in1, (short) 0);
                }
                try {
                    inShort2 = Short.parseShort(in2);
                } catch (NumberFormatException ex){
                    inShort2 = 0;
                    System.err.println("LSHIFT used a var");
                }
                wires.put(out, (short) (inShort1 << inShort2));
            } else if (in.contains("RSHIFT")){
                String[] ins = in.split(" RSHIFT ");
                String in1 = ins[0];
                String in2 = ins[1];
                short inShort1;
                short inShort2;
                try {
                    inShort1 = Short.parseShort(in1);
                } catch (NumberFormatException ex){
                    inShort1 = wires.getOrDefault(in1, (short) 0);
                }
                try {
                    inShort2 = Short.parseShort(in2);
                } catch (NumberFormatException ex){
                    inShort2 = 0;
                    System.err.println("RSHIFT used a var");
                }
                wires.put(out, (short) (inShort1 >>> inShort2));
            } else if (in.contains("NOT")){
                String in1 = in.replace("NOT ","");
                short inShort;
                try {
                    inShort = Short.parseShort(in1);
                } catch (NumberFormatException ex){
                    inShort = wires.getOrDefault(in1, (short) 0);
                }
                wires.put(out, (short) (~inShort));
            } else {
                short inShort;
                try {
                    inShort = Short.parseShort(in);
                } catch (NumberFormatException ex){
                    System.err.println("No instruction");
                    inShort = 0;
                }
                wires.put(out, inShort);
            }

            instructionsFollowed++;
        }
        /*wires.forEach(new BiConsumer() {
            public void accept(Object o, Object o2) {
                System.out.printf("Wire %s has a value of %d\n", o, (short)o2 < 0 ? (short)o2 + 65536 : o2);
            }
        });*/
        System.out.printf("Wire 'a' has a value of %d\n", wires.get("a") < 0 ? wires.get("a") + 65536 : wires.get("a"));


    }
}
