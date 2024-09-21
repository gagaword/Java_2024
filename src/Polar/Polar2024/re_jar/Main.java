package Polar.Polar2024.re_jar;

public class Main {
    public static void main(String[] args) {
//        try {
//            String inputFile = "D:\\IdeaProjects\\Java_2024\\src\\Polar\\Polar2024\\re_jar\\data.txt";
//            String encryptedFile = "D:\\IdeaProjects\\Java_2024\\src\\Polar\\Polar2024\\re_jar\\encrypted.enc";
//            KeyGenerator keyGenerator = new KeyGenerator();
//            String key = keyGenerator.getAesKeyB64String();
//            System.out.println(key);
//
//            FileEncryptor.encryptFile(inputFile, encryptedFile, key);
//
//            System.out.println("File encrypted successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
        String encryptedFilePath = "D:\\IdeaProjects\\Java_2024\\src\\Polar\\Polar2024\\re_jar\\encrypted.enc"; // Path to the encrypted file
        String outputFilePath = "D:\\IdeaProjects\\Java_2024\\src\\Polar\\Polar2024\\re_jar\\xixixi.txt";       // Path to save the decrypted output
        String key = "9FQxXBEE2GCG1Q+AzwVvZA==";                    // AES key (must be 16 bytes for AES-128)

        try {
            // Call the decryptFile method
            FileEncryptor.decryptFile(encryptedFilePath, outputFilePath, key);
            System.out.println("File decrypted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

