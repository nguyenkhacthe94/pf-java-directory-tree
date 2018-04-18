import java.util.Scanner;
import java.io.*;

public class DirectoryTree {
    public static void directoryTree(String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("Folder " + path + " does not exist");
        }
        if (dir.isDirectory()) {
            File[] list = dir.listFiles();
            if (list != null) {
                for (File f : list) {
                    System.out.println(f.getCanonicalPath());
                    directoryTree(f.getCanonicalPath());
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("The program shows the directory tree");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path of the directory: ");
        String path = scanner.nextLine();

        try {
            directoryTree(path);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
