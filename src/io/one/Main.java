package io.one;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * IO输入输出流,对文件进行输入.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        写入文件
        FileWriter fileWriter = new FileWriter("src/io/one/test.txt");
        fileWriter.write("HelloWorld---AAA");
        fileWriter.close();

//        读取文件
        FileReader fileReader = new FileReader("src/io/one/test.txt");
        int index;
        while ((index = fileReader.read()) != -1){
            System.out.print((char)index);
        }
        System.out.println();

//        使用BufferedReader读取文件
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/io/one/test.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
//        使用Files读取所有行
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/io/one/test.txt"));
            for (String string : lines){
                System.out.println(string);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

//        使用Scanner逐个读取
        try {
            Scanner scanner = new Scanner(new File("src/io/one/test.txt"));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
