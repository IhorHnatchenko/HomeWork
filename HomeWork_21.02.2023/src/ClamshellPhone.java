public class ClamshellPhone extends Phone {

    public ClamshellPhone() {
        super();
    }

    public ClamshellPhone(String name, int number) {
        super(name, number);
    }

    @Override
    public void receiveCall(int number, String name) {
        System.out.println("You can clamsell the screen and receive a call.");
    }

    @Override
    public void call(int number, String name) {
        System.out.println("You can clamsell the screen and call.");
    }


}
