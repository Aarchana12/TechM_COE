import java.io.File;
import java.util.Date;

public class LastModified {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\aarch\\Documents\\sample.txt");
        System.out.println("Last Modified: " + new Date(file.lastModified()));
    }
}
