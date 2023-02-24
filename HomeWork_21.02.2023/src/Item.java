public abstract class Item {

    protected int number;
    protected String name;

    public Item() {
    }

    public Item(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
