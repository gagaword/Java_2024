package CTF.CISIN;

import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class android_re {
    public static void main(String[] args) {
        byte[] str2 = {-35,-128,-39,-108,-20,-119,-109,-63};
        Arrays.copyOf(str2, 8);
        SecretKeySpec key = new SecretKeySpec(str2, "AES");
        System.out.println(Arrays.toString(key.getEncoded()));
    }
}
