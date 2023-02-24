public class TouchPhone extends Phone {

    public TouchPhone() {
        super();
    }

    public TouchPhone(String name, int number) {
        super(name, number);
    }


    @Override
    public void receiveCall(int number, String name) {
        System.out.println("You can swipe the screen and receive a call.");
    }

    @Override
    public void call(int number, String name) {
        System.out.println("You can swipe the screen and call.");
    }


}
