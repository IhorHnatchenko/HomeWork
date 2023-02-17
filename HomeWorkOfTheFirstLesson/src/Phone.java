public class Phone {
    private int number;
    private String model;
    private double weight;
    private String name;

    public Phone() {
    }

    public Phone(String model, double weight) {
        this.model = model;
        this.weight = weight;
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

    public void receiveCall(String name) {
        System.out.println("Calling --> " + name);
    }


    public void info() {
        System.out.println(model + ":" +
                " number = " + number +
                ", weight = " + weight +
                '.');
    }
}
