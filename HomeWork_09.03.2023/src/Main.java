import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        // Exercise 1
        System.out.println("Exercise 1");
        int temp = 0;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10000001; i++) {
            integers.add(i);
            temp = i;
        }
        System.out.println("Temp for normal cycle = " + temp + "\n");


        // Exercise 2
        System.out.println("For-each loop: ");
        long l1 = System.currentTimeMillis();
        for (Integer integer : integers) {
            //
        }
        long l2 = System.currentTimeMillis();

        System.out.print("Temp for-each loop = " + (l2 - l1));
        System.out.println("\n");

        // Exercise 3
        System.out.println("Classic for with call integers.size: ");
        long l3 = System.currentTimeMillis();
        for (int i = 0; i < integers.size(); i++) {
            integers.size();
        }
        long l4 = System.currentTimeMillis();
        System.out.print("Temp classic for = " + (l4 - l3));
        System.out.println("\n");

        // Exercise 4
        System.out.println("Classic for with defined integers.size in a variable: ");
        long l5 = System.currentTimeMillis();
        for (int i = 0; i < integers.size(); i++) {
            int size = integers.size();
        }
        long l6 = System.currentTimeMillis();
        System.out.print("Temp for with variable = " + (l6 - l5));
        System.out.println("\n");

        // Exercise 5
        System.out.println("Classic for with defined integers.size in a variable, ");
        System.out.println("and picking from the end: ");
        long l7 = System.currentTimeMillis();
        for (int i = integers.size(); i > 0; i--) {
            int size = integers.size();
        }
        long l8 = System.currentTimeMillis();
        System.out.print("Temp for with variable and picking from the end = " + (l8 - l7));
        System.out.println("\n");

        // Exercise 6
        System.out.println("Work with iterator: ");
        Iterator<Integer> iterator = integers.iterator();
        long l9 = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long l10 = System.currentTimeMillis();
        System.out.print("Temp iterator = " + (l10 - l9));
        System.out.println("\n");

        //Exercise 7
        System.out.println("Work with list iterator: ");
        ListIterator<Integer> integerListIterator = integers.listIterator();
        long l11 = System.currentTimeMillis();
        while (integerListIterator.hasNext()) {
            integerListIterator.next();
        }
        long l12 = System.currentTimeMillis();
        System.out.print("Temp list iterator = " + (l12 - l11));
        System.out.println("\n");

        System.out.println("Work with list iterator revers: ");
        ListIterator<Integer> integerListIterator1 = integers.listIterator(integers.size());
        long l13 = System.currentTimeMillis();
        while (integerListIterator1.hasPrevious()) {
            integerListIterator1.previous();
        }
        long l14 = System.currentTimeMillis();
        System.out.println("Temp list iterator revers = " + (l14 - l13));
        System.out.println("\n");

    }
}