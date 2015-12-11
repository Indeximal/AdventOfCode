/**
 * Created by cyrill on 11.12.15.
 */
public class Day11 {
    public static void main(String[] args) {
        String input = "cqjxjnds";
        String next = null;
        String nextnext = null;
        char[] c = input.toCharArray();
        loop: while (true){
            increase(c);

            boolean hasTriple = false;
            char double1 = ' ';
            char double2 = ' ';
            boolean hasTwoDoubles = false;

            for (int j = 0; j < c.length; j++) {
                if (c[j] == 'i' || c[j] == 'o' || c[j] == 'l'){
                    for (int k = j +1; k < c.length; k++) {
                        c[k] = 'z';
                    }
                    continue loop;
                }
                if (!hasTriple && j < c.length-3){
                    if (c[j] == c[j+1]-1 && c[j] == c[j+2]-2){
                        hasTriple = true;
                    }
                }
                if (!hasTwoDoubles && j < c.length-1){
                    if (c[j] == c[j+1]){
                        if (double1 == ' '){
                            double1 = c[j];
                        } else if (double2 == ' '){
                            if (c[j] != double1) {
                                double2 = c[j];
                                hasTwoDoubles = true;
                            }
                        }
                    }
                }
            }

            if (hasTriple && hasTwoDoubles){
                if (next == null){
                    next = new String(c);
                } else {
                    nextnext = new String(c);
                    break loop;
                }
            }
        }


        System.out.printf("Next password is %s and the second is %s", next, nextnext);
    }

    public static void increase(char[] trg){
        int i = trg.length - 1;
        while (++trg[i] > 'z'){
            trg[i] = 'a';
            i--;
        }
    }
}
