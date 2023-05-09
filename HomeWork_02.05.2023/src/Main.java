import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 4 files with (A.B.C.D)
        //Read all files
        //Read all content from files
        //Merge all chars(String) to one and write to other file.

        String path = "C:\\Users\\RexBeer\\Documents\\Tel-ran\\fileForHomeWork";
        Path fileFroHomeWork = Path.of(path);

        //_E_F_J_K_L_M_N_O_P_Q_R_S_T_U_V_W_X_Y_Z
        String inputData = "A_B_C_D";
        String[] arr = inputData.split("_");

        Arrays.stream(arr).forEach(data -> {
            createFile(Path.of(fileFroHomeWork + "/" + data + ".txt"), data);
        });

        // ========================
        File dir = new File(fileFroHomeWork.toUri());
        File[] files = dir.listFiles();



        System.out.println("Read all files");
        assert files != null;
        Arrays.stream(files).forEach(file -> {
            try {
                System.out.println(Files.readAllLines(file.toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("or");
        Arrays.stream(files).forEach(file -> {
            System.out.println(file.getName());
        });

        System.out.println("Read all content from files");
        List<String> stringList = Arrays.stream(files).map(File::getAbsolutePath).toList();
        stringList.forEach(file -> System.out.println(getDataFromFile(Path.of(file))));

        System.out.println("Merge all chars(String) to one and write to other file.");
        StringBuilder stringBuilder = new StringBuilder();
        stringList.forEach(file -> stringBuilder.append(getDataFromFile(Path.of(file))));
        String result = stringBuilder.toString();
        System.out.println(result);


        String mergeFileName = "/merge.txt";
        Path mergeFilePath = Path.of(path, mergeFileName);
        File mergeFile = new File(mergeFilePath.toUri());

        if(mergeFile.exists()){
            if(result.equals(getDataFromFile(mergeFilePath))){
                //Не понимаю почему не выводит в консоль это уведомление.
                System.out.println("The files are identical.");
            }
        }else {
            System.out.println("New file.");
            createFile(mergeFilePath, result);
        }
    }

    private static String getDataFromFile(Path path) {
        try (FileReader reader = new FileReader(path.toFile())) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void createFile(Path path, String content) {
        System.out.println("Create file " + path);
        try (FileWriter fileWriter = new FileWriter(path.toFile())) {
            fileWriter.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}