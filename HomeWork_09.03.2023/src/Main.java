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
        for (int i = 0; i < 10; i++) {
            integers.add(i);
            temp += i;
        }
        System.out.print(" " + integers + "\n");
        System.out.println("Temp for normal cycle = " + temp + "\n");


        // Exercise 2
        int tempEx2 = 0;
        System.out.println("Exercise 2");
        for (Integer integer : integers) {
            System.out.print(" " + integer);
            tempEx2 += integer;
        }
        System.out.print("\nTemp for exercise 2 = " + tempEx2);
        System.out.println("\n");

        // Exercise 3
        int tempEx3 = 0;
        System.out.println("Exercise 3");
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(" " + i);
            tempEx3 += i;
        }
        System.out.print("\nTemp for exercise 3 = " + tempEx3);
        System.out.println("\n");

        // Exercise 4
        int tempEx4 = 0;
        int size = integers.size();
        System.out.println("Exercise 4");
        for (int i = 0; i > size; i++){
            System.out.print(i);
            tempEx4 += i;
        }
        System.out.println();

        // Exercise 5
        int tempEx5 = 0;
        System.out.println("Exercise 5");
        for (int i = integers.size(); i > 0; i--) {
            System.out.print(" " + i);
            tempEx5 += i;
        }
        System.out.print("\nTemp for exercise 5 = " + tempEx5);
        System.out.println("\n");

        // Exercise 6
        int tempEx6 = 0;
        System.out.println("Exercise 6");
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            tempEx6 += iterator.next();
        }
        System.out.print("Temp for exercise 6 = " + tempEx6);
        System.out.println("\n");

        //Exercise 7
        System.out.println("Exercise 7");
        int tempListIterator = 0;
        ListIterator<Integer> integerListIterator = integers.listIterator();
        while (integerListIterator.hasNext()){
            tempListIterator += integerListIterator.next();
        }
        System.out.print("Temp for list iterator = " + tempListIterator);
        System.out.println("\n");

        int tempListIteratorRev = 0;
        ListIterator<Integer> integerListIterator1 = integers.listIterator(integers.size());
        while (integerListIterator1.hasPrevious()){
            tempListIteratorRev += integerListIterator1.previous();
        }
        System.out.println("Temp for list iterator revers = " + tempListIteratorRev);
        System.out.println("\n");

    }
}