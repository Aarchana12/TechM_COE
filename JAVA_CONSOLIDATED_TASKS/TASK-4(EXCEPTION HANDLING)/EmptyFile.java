import java.io.File;
import java.io.FileNotFoundException;

public class EmptyFile {
    static void checkFile(String fileName) throws Exception {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            throw new Exception("File is empty or does not exist");
        }
        System.out.println("File has content");
    }

    public static void main(String[] args) {
        try {
            checkFile("C:\\Users\\aarch\\Documents\\sample.txt");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
