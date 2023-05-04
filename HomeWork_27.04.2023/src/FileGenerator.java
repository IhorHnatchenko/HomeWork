import java.io.File;
import java.io.FileWriter;

public class FileGenerator {

    public static void generateFile(String directoryPath, String fileName, String text){
        try {
            File directory = new File(directoryPath);
            if(!directory.exists()){
                directory.mkdir();
            }

            File file = new File(directory, fileName);

            FileWriter writer = new FileWriter(file);
//            writer.write(text);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
