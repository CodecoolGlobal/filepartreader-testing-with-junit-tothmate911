import java.io.*;

public class Main {
    public static void main(String[] args) {
        FilePartReader fpr = new FilePartReader();
        String filePath = "/home/mate/codecool/oop/filepartreader-testing-with-junit-tothmate911/src/test.txt";
        String filePath1 = "src/main/resources/test.txt";
        fpr.setup(filePath1, 2, 3);

        fpr.setup("nonExistingFile", 1, 2);

        try {
            System.out.println(fpr.read());
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(fpr.readLines());

    }
}
