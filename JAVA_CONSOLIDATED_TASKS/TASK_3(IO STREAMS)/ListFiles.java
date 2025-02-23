import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\aarch\\Documents");
        String[] files = dir.list();
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
