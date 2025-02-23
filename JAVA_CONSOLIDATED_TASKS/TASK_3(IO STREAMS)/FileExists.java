import java.io.File;

public class FileExists {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\aarch\\Documents\\sample.txt");
        System.out.println(file.exists() ? "Exists" : "Does not exist");
    }
}
