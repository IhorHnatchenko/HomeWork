import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[][] input = {{"Ihor", "Hnatchenko"}, {"Anna", "Hnatchenko"}, {"Bob", "Note"}, {"Yi", "Naruhami"}};

        System.out.println("Names: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print("|" + input[i][0] + "| ");
        }
        System.out.println("\nLast names: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print("|" + input[i][1] + "| ");
        }
        List<Person> personList = new ArrayList<>();
        System.out.print("\n\nNames and last names in array list: ");
        for (int i = 0; i < input.length; i++) {
            personList.add(new Person(input[i][0], input[i][1]));
        }
        System.out.println("\n" + personList);

        System.out.print("\nList sort by name:");
        List<Person> personListSortByName = personList;
        Comparator comparatorByName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Collections.sort(personListSortByName, comparatorByName);
        System.out.println("\n" + personListSortByName);

        System.out.print("\nList sort by last name:");
        List<Person> personListSortByLastName = personList;
        Comparator comparatorByLastName = (o1,o2) -> o1.getLastName().compareTo(o2.getLastName());
        Collections.sort(personListSortByLastName, comparatorByLastName);
        System.out.println("\n" + personListSortByLastName);



        System.out.print("\nList sort by name and last name:");
        List<Person> personListComparatorByNameAndLastName = personList;
        Comparator comparatorByNameAndLastName = (o1, o2) -> {
            int sortByName = o1.getName().compareTo(o2.getName());
            int sortByLastName = o1.getLastName().compareTo(o2.getLastName());
            return sortByName == 0 ? sortByLastName : sortByName;
        };
        Collections.sort(personListComparatorByNameAndLastName, comparatorByNameAndLastName);
        System.out.println("\n" + personListComparatorByNameAndLastName);
    }
}