
/**
 * Created by cyrill on 10.12.15.
 */
public class Day10 {
    public static void main(String[] args) {
        String input = "1113222113";
        for (int i = 0; i < 50; i++) {
            if (i == 40){
                System.out.printf("40 times: %d chars\n", input.length());
            }
            char[] chars = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                int k = 1;
                while (j + k < chars.length && chars[j] == chars[j + k]){
                    k++;
                }
                sb.append(k);
                sb.append(chars[j]);
                j += k - 1;
            }
            input = sb.toString();
        }
        System.out.printf("50 times: %d chars\n", input.length());
    }
}
