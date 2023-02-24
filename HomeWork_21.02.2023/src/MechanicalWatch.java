public class MechanicalWatch extends Watch {

    public MechanicalWatch() {
    }

    public MechanicalWatch(String name, int number) {
        super(name, number);
    }

    @Override
    public void showTime() {
        System.out.println("10:25");
    }

    @Override
    public void alarm() {
        System.out.println("7:00");
    }

}
