public class Person {
    private String name;
    private String lastName;

    public Person() {
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name = |" + name + "| " +
                "lastName = |" + lastName + "| " +
                "}\n";
    }
}
