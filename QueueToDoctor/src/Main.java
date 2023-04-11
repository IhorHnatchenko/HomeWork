import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello doctor!");

        Queue<String> queue = new LinkedList<>();
        queue.add("9:00");
        queue.add("9:30");
        queue.add("10:00");
        queue.add("10:30");
        queue.add("11:00");
        int i = 0;
        Map<Integer, String> integerStringMap = new TreeMap<>();
        for (String index : queue) {
            ++i;
            integerStringMap.put(i, index);
        }
        printMap(integerStringMap);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Map<Integer, String> integerStringTreeMap = new TreeMap<>();
        while (!(integerStringMap.isEmpty())) {
            System.out.println("Welcome in our hospital.");
            System.out.print("Please enter your name: ");
            String name = scanner1.nextLine();
            System.out.print("Choose your visit time: ");
            int time = scanner.nextInt();
            for (Map.Entry<Integer, String> pair : integerStringMap.entrySet()) {
                if (time == pair.getKey()) {
                    System.out.println(name + " your visit at " + pair.getValue());
                    integerStringTreeMap.put(pair.getKey(), name);
                    integerStringMap.remove(pair.getKey());
                    printMap(integerStringMap);
                    break;
                }
            }
        }
        printMap(integerStringTreeMap);
    }

    public static void printMap(Map<Integer, String> integerStringMap) {
        for (Map.Entry<Integer, String> pair : integerStringMap.entrySet()) {
            System.out.println(pair.getKey() + "-->" + pair.getValue());
        }
    }

    public static void printMapStringString(Map<String, String> stringStringMap) {
        for (Map.Entry<String, String> pair : stringStringMap.entrySet()) {
            System.out.println(pair.getKey() + "-->" + pair.getValue());
        }
    }
}