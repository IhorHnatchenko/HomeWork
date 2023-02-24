public abstract class Watch extends Item {

    public Watch() {
        super();
    }

    public Watch(String name, int number) {
        super(name, number);
    }

    abstract public void showTime();

    abstract public void alarm();


}
