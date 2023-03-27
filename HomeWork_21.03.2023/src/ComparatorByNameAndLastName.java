import java.util.Comparator;

public class ComparatorByNameAndLastName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        SortByName sortByName = new SortByName();
        int resultByName = sortByName.compare(o1,o2);
        SortByLastName sortByLastName = new SortByLastName();
        int resultByLastName = sortByLastName.compare(o1,o2);

        return resultByName == 0 ? resultByLastName : resultByName;
    }
}
