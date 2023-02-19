public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        TouchPhone touchPhone = new TouchPhone();
        touchPhone.setName("Touch phone");
        touchPhone.setNumber(574693390);

        SliderPhone sliderPhone = new SliderPhone();
        sliderPhone.setName("Slider phone");
        sliderPhone.setNumber(655674743);

        ClamshellPhone clamshellPhone = new ClamshellPhone();
        clamshellPhone.setName("Clamshell phone");
        clamshellPhone.setNumber(482392940);

        Phone[] phones = {touchPhone, sliderPhone, clamshellPhone};
        for (Phone sPhone : phones) {
            sPhone.call(sPhone.getNumber(), sPhone.getName());
            sPhone.receiveCall(sPhone.getNumber(), sPhone.getName());
            System.out.println();
        }

        makeCall(touchPhone.getNumber());
        receiveCall(touchPhone.getNumber());

        makeCall((sliderPhone.getNumber()));
        receiveCall(sliderPhone.getNumber());

        makeCall(clamshellPhone.getNumber());
        receiveCall(clamshellPhone.getNumber());

        System.out.println();

        makeCalls(phones);
        receiveCalls(phones);

    }

    static void makeCall(int number) {
        System.out.println("Now you are calling \n" + number);
    }

    static void receiveCall(int number) {
        System.out.println("Now call you number: \n" + number);
    }

    static void makeCalls(Phone[] phones) {
        for (Phone sPhone : phones) {
            System.out.println("Now you are calling \n" + sPhone.getNumber());
        }
    }

    static void receiveCalls(Phone[] phones) {
        for (Phone sPhone : phones) {
            System.out.println("Now call you number: \n" + sPhone.getNumber());
        }
    }
}