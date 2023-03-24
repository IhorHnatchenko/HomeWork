import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 1, 5, 3, 3, 4, 3, 2, 4, 2, 7, 6, 9, 11, 14, 1, 7, 15, 0, 8};
        System.out.println("Simple array of numbers: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|" + arr[i] + "| ");
        }

        System.out.println("\n\nOnly unique elements: ");
        MySet.onlyUniqueElements(arr);

        System.out.println("\nOnly duplicate elements: ");
        MySet.onlyDuplicateElements(arr);

        System.out.println();
        Set<Students> studentsSet = new HashSet<>();
        studentsSet.add(new Students("Anna", "Hnatchenko", 19));
        studentsSet.add(new Students("Yi", "Yamamoto", 17));
        studentsSet.add(new Students("Ihor", "Hnatchenko", 21));
        studentsSet.add(new Students("Ihor", "Hnatchenko", 21));
        studentsSet.add(new Students("Hori", "Nisan", 18));

        System.out.println(studentsSet);


    }


}