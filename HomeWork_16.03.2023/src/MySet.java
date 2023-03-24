import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MySet {
    public static void onlyUniqueElements(int[] arr) {
        Set<Integer> setForUnique = new TreeSet<>();
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            setForUnique.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    setForUnique.remove(arr[j]);
                }
            }
        }
        System.out.println(setForUnique);
    }

    public static void onlyDuplicateElements(int[] arr) {
        Set<Integer> setForDuplicate = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    setForDuplicate.add(arr[j]);
                }
            }
        }
        System.out.println(setForDuplicate);
    }
}
