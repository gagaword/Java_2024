package CTF.BugkuCTF.time;

public class exp {
    public static boolean is2(int n) {
        if(n <= 3) {
            return n > 1;
        }

        if(n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for(int i = 5; i * i <= n; i += 6) {
            if(n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int time = 200000;
        int k = 0;
        while (time > 0){
           if (is2(time)){
               k += 100;
           }else{
               k--;
           }
            time--;
        }
        System.out.println("k = " + k);
    }

}
