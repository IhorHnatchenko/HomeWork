import java.io.File;
import java.util.Arrays;

public class DirectoryDeleter {
    public static void deleteDirectory(File directory) {
        if(directory.isDirectory()){
            File[] files = directory.listFiles();
            if(files != null){
                Arrays.stream(files).forEach(DirectoryDeleter::deleteDirectory);
            }
        }
        directory.delete();
    }
}
