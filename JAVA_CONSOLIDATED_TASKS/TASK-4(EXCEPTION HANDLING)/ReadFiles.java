import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFiles {
    static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }

    public static void main(String[] args) {
        try {
            readFile("C:\\Users\\aarch\\Documents\\sample.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found");
        }
    }
}
