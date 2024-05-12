package review.Day04;

import java.util.HashMap;
import java.util.Map;

public class Main_map {
    public static void main(String[] args) {
        Map<String, Integer> age = new HashMap<>();
        age.put("王五", 20);
        age.put("小三", 10);

        System.out.println(age.get("王五"));
        System.out.println(age.get("小三"));
        
        boolean is = age.containsKey("王五");
        System.out.println("is = " + is);

        boolean iss = age.containsValue(20);
        System.out.println("iss = " + iss);

        for (String name : age.keySet()){
            int ages = age.get(name);
            System.out.println(name +":" + ages);
        }


        for (Map.Entry<String, Integer> entry : age.entrySet()){
            String name = entry.getKey();
            int ages = entry.getValue();
            System.out.println(name + ":" + ages);
        }
    }
}
