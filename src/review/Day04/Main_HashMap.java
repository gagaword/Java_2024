package review.Day04;


import java.util.HashMap;

/**
 * hashMap
 * map
 */
public class Main_HashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> scores = new HashMap<>();
        scores.put("李四", 220);
        scores.put("张三", 100);

        System.out.println("scores = " + scores.get("李四"));
//        scores.remove("张三");
        System.out.println(scores.get("张三"));

        for (String name: scores.keySet()){
            int score = scores.get(name);
            System.out.println(name + ":" + score);
        }
    }
}
