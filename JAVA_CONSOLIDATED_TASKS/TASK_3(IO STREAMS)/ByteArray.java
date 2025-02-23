import java.io.File;
import java.io.FileInputStream;

public class ByteArray {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\aarch\\Documents\\sample.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        System.out.println(new String(data));
    }
}
