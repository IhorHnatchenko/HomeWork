public class DigitalWatch extends Watch {

    public DigitalWatch() {
    }

    public DigitalWatch(String name, int number) {
        super(name, number);
    }

    @Override
    public void showTime() {
        System.out.println("11:53");
    }

    @Override
    public void alarm() {
        System.out.println("6:00");
    }


}
