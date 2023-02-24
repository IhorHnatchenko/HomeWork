public class QuartzWatch extends Watch {

    public QuartzWatch() {
    }

    public QuartzWatch(String name, int number) {
        super(name, number);
    }

    @Override
    public void showTime() {
        System.out.println("9:00");
    }

    @Override
    public void alarm() {
        System.out.println("5:00");
    }


}
