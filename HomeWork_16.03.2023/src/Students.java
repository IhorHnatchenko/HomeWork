import java.util.Comparator;
import java.util.Objects;

public class Students {
    private String first_name;
    private String last_name;
    private int age;

    public Students(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nStudents-->{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return age == students.age && first_name.equals(students.first_name) && last_name.equals(students.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, age);
    }
}
