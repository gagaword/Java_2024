package CTF.XCTF.GuesstheNumber;

import java.math.BigInteger;

public class exp {
    static String XOR(String _str_one, String _str_two) {
        BigInteger i1 = new BigInteger(_str_one, 16);
        BigInteger i2 = new BigInteger(_str_two, 16);
        BigInteger res = i1.xor(i2);
        String result = res.toString(16);
        return result;
    }
    public static void main(String[] args) {
        String str_one = "4b64ca12ace755516c178f72d05d7061";
        String str_two = "ecd44646cfe5994ebeb35bf922e25dba";
        String result = XOR(str_one, str_two);
        System.out.println("result = " + result);
    }
}
