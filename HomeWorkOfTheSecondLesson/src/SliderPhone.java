public class SliderPhone extends Phone {

    @Override
    public void receiveCall(int number, String name) {
        super.receiveCall(number, name);
        System.out.println("You can slide the screen and receive a call.");
    }

    @Override
    public void call(int number, String name) {
        super.call(number, name);
        System.out.println("You can slide the screen and call.");
    }
}
