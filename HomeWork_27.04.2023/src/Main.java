import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        File fileForDelete = new File("C:/newFile");
        DirectoryDeleter.deleteDirectory(fileForDelete);


        String message = "This is my first experience when I myself work with IO API";
        String[] messages = message.split(" ");
        System.out.println(Arrays.toString(messages));

        Map<String, String> collect = Arrays.stream(messages)
                .collect(Collectors.toMap(s -> s, s -> s + ".txt"));
        System.out.println(collect);

        String directoryPath = "C:/newFile";


        collect.forEach((key, value) -> {
            String fileName = "/" + value + ".txt";
            String filePath = directoryPath + "/" + fileName;
            String text = key;
            FileGenerator.generateFile(directoryPath, fileName, text);
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.write(text);
                writer.close();
                System.out.println("File created: " + filePath);
            } catch (IOException e) {
                System.out.println("Error creating file: " + filePath);
                e.printStackTrace();
            }

        });

        List<String> stringList = Arrays.asList(message.split("\\s+"));

        List<String> result = new ArrayList<>();

        ListOutputWriter writer = new ListOutputWriter(result);


        stringList.forEach(word -> {
            try {
                writer.write(word + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        result.stream().forEach(System.out::print);




    }
}