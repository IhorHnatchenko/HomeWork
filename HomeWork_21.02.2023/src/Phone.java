import java.awt.event.InputMethodEvent;

public abstract class Phone extends Item {
    public Phone() {
        super();
    }

    public Phone(String name, int number) {
        super(name, number);
    }

    abstract public void receiveCall(int number, String name);

    abstract public void call(int number, String name);
}
