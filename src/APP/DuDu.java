package APP;//import android.util.Base64;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes.dex */
public class DuDu {
    Cipher deCipher;
    Cipher enCipher;

    public DuDu(String key, String iv) throws Exception {
        if (key == null) {
            throw new NullPointerException("Parameter is null!");
        }
        InitCipher(key.getBytes(), iv.getBytes());
    }

    private void InitCipher(byte[] secKey, byte[] secIv) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(secKey);
        DESKeySpec dsk = new DESKeySpec(md.digest());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dsk);
        IvParameterSpec iv = new IvParameterSpec(secIv);
        this.enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        this.deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        this.enCipher.init(1, key, iv);
        this.deCipher.init(2, key, iv);
    }

    public String encrypt64(byte[] data) throws Exception {
        byte[] encryptedBytes = this.enCipher.doFinal(data);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public byte[] decrypt64(String data) throws Exception {
        return this.deCipher.doFinal(Base64.getDecoder().decode(data));
    }

    public String sign(String data) throws Exception {
        String append = "sdlkjsdljf0j2fsjk";

        // 将 JSON 字符串转换为 Map
        Map<String, String> paramMap = Arrays.stream(data.replace("{", "").replace("}", "").split(","))
                .map(pair -> pair.split(":"))
                .collect(Collectors.toMap(
                        kv -> kv[0].trim().replace("\"", ""),
                        kv -> kv[1].trim().replace("\"", "")
                ));

        // 对 Map 中的键进行排序
        List<String> keys = new ArrayList<>(paramMap.keySet());
        Collections.sort(keys);

        // 拼接参数字符串
        String paramStr = keys.stream()
                .filter(key -> !"sign".equals(key))
                .map(key -> {
                    return key + "=" + URLEncoder.encode(paramMap.get(key), StandardCharsets.UTF_8);
                })
                .collect(Collectors.joining("&")) + "&key=" + URLEncoder.encode(append, StandardCharsets.UTF_8);

        System.out.println("sign明文：" + paramStr);
        // 对拼接后的参数字符串进行 MD5 加密
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(paramStr.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();

        for (byte b : digest) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString().toUpperCase();
    }
    public static void main(String[] args) throws Exception {
        DuDu du = new DuDu("65102933","32028092");

        String enc = "NIszaqFPos1vd0pFqKlB42Np5itPxaNH//FDsRnlBfgL4lcVxjXiiwWX6BsVnaSf5Kg2oqCHzD7ivMxRVs5cIDxky6Ke99e/z7WHu5MHvSJa4ZjhlNb8mDZ+UKE6aw+ZCrQH83LHd9CwOvNs1sfDtq86KaHiHnyR0EUn2NEq34rdlapFkxbokR3HKO2ZTNuCsOva7cf24eWWVj7RO4FnxsLXZvln4j7J782gc43W1JzGCk4sZFO9fA==";
        String decryptedString = new String(du.decrypt64(enc));
        System.out.println("明文：" + decryptedString);

        System.out.println("sign密文:" + du.sign(decryptedString));
    }
}