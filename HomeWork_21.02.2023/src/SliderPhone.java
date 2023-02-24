public class SliderPhone extends Phone {

    public SliderPhone() {
        super();
    }

    public SliderPhone(String name, int number) {
        super(name, number);
    }

    @Override
    public void receiveCall(int number, String name) {
        System.out.println("You can slide the screen and receive a call.");
    }

    @Override
    public void call(int number, String name) {
        System.out.println("You can slide the screen and call.");
    }


}
