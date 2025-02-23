import java.io.File;

public class FileSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\aarch\\Documents\\sample.txt");
        long size = file.length();
        System.out.println("Size: " + size + " bytes");
        System.out.println("Size: " + (size / 1024.0) + " KB");
        System.out.println("Size: " + (size / (1024.0 * 1024.0)) + " MB");
    }
}
