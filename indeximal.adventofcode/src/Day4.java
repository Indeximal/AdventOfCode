import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by cyrill on 05.12.15.
 */
public class Day4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String code = "ckczppom";
        //String code = "abcdef";
        MessageDigest md = MessageDigest.getInstance("MD5");
        int count = 0;
        boolean found5 = false;

        while (true){
            String input = "" + code + count;
            md.update(input.getBytes());
            byte[] out = md.digest();
            if (out[0] == 0 && out[1] == 0 && out[2] < 16 && out[2] >= 0){
                if (!found5){
                    System.out.printf("Found hash with at least 5 leading zeros: '%s'\n", input);
                }
                found5 = true;
                if (out[2] == 0){
                    System.out.printf("Found hash with at least 6 leading zeros: '%s'\n", input);
                    break;
                }
            }
            md.reset();
            count++;

        }
    }
}
