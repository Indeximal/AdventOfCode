import javax.xml.bind.DatatypeConverter;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by cyrill on 05.12.15.
 */
public class Day4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String code = "ckczppom";
        MessageDigest md = MessageDigest.getInstance("MD5");
        int count = 0;
        int[] numsOfLeadingZerosToFind = {5, 6};
        String[] hashesFound = new String[numsOfLeadingZerosToFind.length];

        tryLoop: while (true){
            String input = "" + code + count;
            md.update(input.getBytes());
            byte[] out = md.digest();
            String hash = DatatypeConverter.printHexBinary(out);
            int foundHashed = 0;
            for (int i = 0; i < numsOfLeadingZerosToFind.length; i++) {
                if (hashesFound[i] != null){
                    foundHashed++;
                    if (foundHashed >= numsOfLeadingZerosToFind.length){
                        break tryLoop;
                    }
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < numsOfLeadingZerosToFind[i]; j++) {
                    sb.append('0');
                }
                if (hash.startsWith(sb.toString())){
                    hashesFound[i] = input;
                }
            }

            md.reset();
            count++;
        }
        for (int i = 0; i < numsOfLeadingZerosToFind.length; i++) {
            System.out.printf("The lowest hash with %d leading zeros is %s('%s')\n", numsOfLeadingZerosToFind[i], md.getAlgorithm(), hashesFound[i]);
        }
    }
}
