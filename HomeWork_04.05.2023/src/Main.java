import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String phoneNumber = "123 4567";
        String mail = "kaonochi@gmail.com";
        if (isPhoneNumber(phoneNumber)) {
            System.out.println("Phone number is correct.");
        } else {
            System.out.println("Phone number is wrong.");
        }
        
        if (isMail(mail)) {
            System.out.println("Mail is correct.");
        } else {
            System.out.println("Mail is wrong.");
        }
        System.out.println();

        String ip1 = "000.14.33.156";
        String ip2 = "0.0.0.0";
        String ip3 = "00.1.23.23.23";
        String ip4 = "i.am.not.an.ip";
        List<String> stringList = Arrays.asList(ip1, ip2, ip3, ip4);
        stringList.forEach(ip -> {
            if (isValidIp(ip)) {
                System.out.println("Ip is correct.");
            } else {
                System.out.println("Ip is wrong.");
            }
        });


    }

    private static boolean isValidIp(String ip) {
        // Честно говря эту часть заданиня я сделал с помощью интернета.
        // Я попытался в этом разобраться, но не уверен что всё правильно понял.
        String regDigit = "((\\d{1,2}|0\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d{1,2}|0\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])";

        Pattern pattern = Pattern.compile(regDigit);
        return pattern.matcher(ip).matches();
    }

    private static boolean isMail(String mail) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9.-]{1,3}$";

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(mail).matches();
    }

    private static boolean isPhoneNumber(String phoneNumber) {
        String regex = "^\\d{7}$|^\\d{3} \\d{4}$";

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phoneNumber).matches();
    }
}