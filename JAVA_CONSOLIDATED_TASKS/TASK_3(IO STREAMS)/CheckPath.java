import java.io.File;

public class CheckPath {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\aarch\\Documents\\sample.txt");
        if (file.isDirectory()) {
            System.out.println("It is a directory");
        } else if (file.isFile()) {
            System.out.println("It is a file");
        } else {
            System.out.println("Not found");
        }
    }
}
