import java.util.*;

public class Main  {

    public static void main(String[] args) {
        String[][] input = {{"abc", "last"}, {"pklz", "yelp"}, {"rpng", "note"}, {"ppza", "xyz"}};

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
        for(int i = 0; i < input.length; i++){
            personList.add(new Person(input[i][0],input[i][1]));
        }
        System.out.println("\n" + personList);

        System.out.print("\nList sort by name:");
        List<Person> personListSortByName = personList;
        SortByName sortByName = new SortByName();
        Collections.sort(personListSortByName, sortByName);
        System.out.println("\n" + personListSortByName);

        System.out.print("\nList sort by last name:");
        List<Person> personListSortByLastName = personList;
        SortByLastName sortByLastName = new SortByLastName();
        Collections.sort(personListSortByLastName, sortByLastName);
        System.out.println("\n" + personListSortByLastName);


        System.out.print("\nList sort by name and last name:");
        List<Person> personListComparatorByNameAndLastName = personList;
        ComparatorByNameAndLastName comparatorByNameAndLastName = new ComparatorByNameAndLastName();
        Collections.sort(personListComparatorByNameAndLastName,comparatorByNameAndLastName);
        System.out.println("\n" + personListComparatorByNameAndLastName);





    }

    private static void objectComparison(String[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j) {
                    break;
                }
                System.out.println("Comparison name " + i + " and " + j + ": " + input[i][0].equals(input[j][0]));
            }

        }
    }
}