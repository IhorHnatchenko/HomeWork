package FilePrograms;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileEx{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        File file = new File("out.txt");
        PrintWriter writer = new PrintWriter(file);
        System.out.println("Enter a number ");
        int number = scanner.nextInt();
        writer.println(number);
        writer.close();

    }



}
