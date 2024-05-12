package CTF.BUUCTF.Reverse;


public class exp {
    public static void main(String[] args) {
        int[] enc = {180, 136, 137, 147, 191, 137, 147, 191, 148, 136, 133, 191, 134, 140, 129, 135, 191, 65};
        // 解密得到的字符串
        String decryptedString = decrypt(enc);
        System.out.println("解密后的字符串为: " + decryptedString);
    }

    public static String decrypt(int[] ciphertextArray) {
        StringBuilder decryptedString = new StringBuilder();
        // 逐个解密密文数组中的每个元素
        for (int ciphertext : ciphertextArray) {
            // 逆向异或运算
            int result = (ciphertext ^ 32) - '@';
            // 将结果转换为字符并添加到解密后的字符串中
            decryptedString.append((char) result);
        }
        return decryptedString.toString();
    }
}
