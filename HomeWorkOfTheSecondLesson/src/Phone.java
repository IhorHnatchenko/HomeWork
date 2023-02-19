public class Phone {

    private int number;
    private String name;

    public Phone() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void receiveCall(int number, String name) {
        System.out.println("Phone: " + name + " receive call " + number + ".");
    }

    public void call(int number, String name) {
        System.out.println("Phone: " + name + " call to " + number + ".");
    }
}
