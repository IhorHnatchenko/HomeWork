package Example3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Input and code: ");
        int code = scanner.nextInt();*/
        HttpCodes.findValueByCode(101);
        HttpCodes.findValueByCode(202);
        HttpCodes.findValueByCode(303);
        HttpCodes.findValueByCode(404);
        HttpCodes.findValueByCode(505);
    }
}
