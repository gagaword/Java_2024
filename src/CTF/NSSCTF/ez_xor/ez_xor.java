package CTF.NSSCTF.ez_xor;

/*
toCharArray() 是Java中字符串类 String 提供的一个方法，其作用是将字符串转换为字符数组。
这个方法返回一个新的字符数组，其中包含了字符串中的每个字符。
 */
public class ez_xor{
    public static void  main(String[] args){
        char[] data= "E`}J]OrQF[V8zV:hzpV}fVF[t".toCharArray();
        for (int i = 0; i < data.length; i++) {
                data[i] ^= 9;
            System.out.print(data[i]);
        }
    }
}
