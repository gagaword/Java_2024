package review.day03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class text {
    public static void main(String[] args) throws IOException {
        File file = new File("src/review/day03/test.txt");
        Files.lines(file.toPath()).forEach(line ->{
//            System.out.println("line = " + line);
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            System.out.println("sb = " + sb);
        });
    }
}
