public class Main {
    public static void main(String[] args) {
        System.out.println("Hello teacher!\n");

        Phone touchPhone = new TouchPhone("Touch phone", 1);
        Phone touchPhone1 = new TouchPhone("Touch phone", 2);
        Phone touchPhone2 = new TouchPhone("Touch phone", 3);

        Phone sliderPhone = new SliderPhone("Slider phone", 4);
        Phone sliderPhone1 = new SliderPhone("Slider phone", 5);
        Phone sliderPhone2 = new SliderPhone("Slider phone", 6);

        Phone clamshellPhone = new ClamshellPhone("Clamshell phone", 7);
        Phone clamshellPhone1 = new ClamshellPhone("Clamshell phone", 8);
        Phone clamshellPhone2 = new ClamshellPhone("Clamshell phone", 9);

        Watch mechanicalWatch = new MechanicalWatch("Mechanical watch", 11);
        Watch mechanicalWatch1 = new MechanicalWatch("Mechanical watch", 22);
        Watch mechanicalWatch2 = new MechanicalWatch("Mechanical watch", 33);

        Watch digitalWatch = new DigitalWatch("Digital watch", 44);
        Watch digitalWatch1 = new DigitalWatch("Digital watch", 55);
        Watch digitalWatch2 = new DigitalWatch("Digital watch", 66);

        Watch quartzWatch = new QuartzWatch("Quartz watch", 77);
        Watch quartzWatch1 = new QuartzWatch("Quartz watch", 88);
        Watch quartzWatch2 = new QuartzWatch("Quartz watch", 99);

        //Так как у нас есть массив с большим количеством объектов, этот массив не будет использоваться в моём кеоде
        //Но так как в задании было создать такой массив, он бдуте создан
        Phone[] phones = {touchPhone, touchPhone1, touchPhone2,
                sliderPhone, sliderPhone1, sliderPhone2,
                clamshellPhone, clamshellPhone1, clamshellPhone2};




        Item[] items = {touchPhone, touchPhone1, touchPhone2,
                sliderPhone, sliderPhone1, sliderPhone2,
                clamshellPhone, clamshellPhone1, clamshellPhone2,
                mechanicalWatch, mechanicalWatch1, mechanicalWatch2,
                digitalWatch, digitalWatch1, digitalWatch2,
                quartzWatch, quartzWatch1, quartzWatch2};

        makeCalls(items);
        receiveCalls(items);

        showTimes(items);
        showAlarms(items);
    }

    static void showAlarms(Item[] items) {
        System.out.println("It is method alarms.\n");
        for (Item sItem : items) {
            if (sItem instanceof Watch) {
                System.out.println("It is item: " + sItem);
                ((Watch) sItem).alarm();

            }
        }
        System.out.println("__________________________________");
    }

    static void showTimes(Item[] items) {
        System.out.println("It is method show time.\n");
        for (Item sItem : items) {
            if (sItem instanceof Watch) {
                System.out.println("It is item: " + sItem);
                ((Watch) sItem).showTime();
            }
        }
        System.out.println("__________________________________");
    }

    static void makeCalls(Item[] items) {
        System.out.println("It is method make calls.\n");
        for (Item sItem : items) {
            if (sItem instanceof Phone) {
                System.out.println("It is item: " + sItem);
                ((Phone) sItem).call(sItem.getNumber(), sItem.getName());
            }
        }
        System.out.println("__________________________________");
    }

    static void receiveCalls(Item[] items) {
        System.out.println("It is method receive calls.\n");
        for (Item sItem : items) {
            if (sItem instanceof Phone) {
                System.out.println("It is item: " + sItem);
                ((Phone) sItem).receiveCall(sItem.getNumber(), sItem.getName());
            }
        }
        System.out.println("__________________________________");
    }
}