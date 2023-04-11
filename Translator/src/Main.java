import java.util.*;
import java.util.zip.ZipEntry;

public class Main {
    public static void main(String[] args) {
        System.out.println("Translator");
        Map<String,String> worldAndTranslate = new HashMap<>();
        worldAndTranslate.put("cat", "кот");
        worldAndTranslate.put("dog", "собака");
        worldAndTranslate.put("bird", "птица");
        worldAndTranslate.put("car", "машина");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter english world for translate: ");
        String usersWord = scanner.next();
        for(Map.Entry<String,String> pair : worldAndTranslate.entrySet()){
            if(usersWord.equals(pair.getKey())){
                System.out.println(pair.getValue());
            }else{
                System.out.println("I don't have translate this word.");
                System.out.print("Please enter translate this word: ");
                String newWord = scanner.next();
                worldAndTranslate.put(usersWord,newWord);
                System.out.println(usersWord + " --> " + newWord);
                return;
            }
        }


    }
}