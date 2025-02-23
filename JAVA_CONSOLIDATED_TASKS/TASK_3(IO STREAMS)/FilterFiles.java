import java.io.File;

public class FilterFiles {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\aarch\\JAVA_TASKS");
        String[] files = dir.list((d, name) -> name.endsWith(".class"));
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
