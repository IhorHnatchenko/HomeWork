public class Main {
    public static void main(String[] args) {
        System.out.println("Hello teacher!\n");

        Person person1 = new Person();
        person1.setFullName("Yumi Hanako");
        person1.setAge(16);
        person1.move();
        person1.talk(person1.getAge());

        Person person2 = new Person("Ihor Hnatchenko", 21);
        person2.move();
        person2.talk(person2.getAge());

        System.out.println();
        Phone phone1 = new Phone("hp3000", 100.5);
        phone1.setNumber(564738290);
        phone1.setName("Ihor");
        Phone phone2 = new Phone("hp3001", 100.1);
        phone2.setNumber(564738291);
        phone2.setName("Yi");
        Phone phone3 = new Phone("hp3002", 99.5);
        phone3.setNumber(564738292);
        phone3.setName("Makima");

        /*В этой части задания я понял что вы хотел, что бы я вставил номер телефона в метод receiveCall тоесть --> sPone.receiveCall(sPone.getNumber()); предворительно изменив
        тип переменной в методе receiveCall на int.
        Но мне показалось это как-то не логично. И я добавил ещё и имя к номеру. Не знаю хорошо у меня получилось или нет.
        Я пишу этот коментарий что бы вы знал что я могу это сделать.*/
        Phone[] phones = {phone1, phone2, phone3};
        for (Phone sPone : phones) {
            sPone.info();
            switch (sPone.getNumber()) {
                case 564738290:
                    sPone.receiveCall(sPone.getName());
                    System.out.println("IT IS THE PHONE NUMBER: " + sPone.getNumber());
                    System.out.println();
                    break;
                case 564738291:
                    sPone.receiveCall(sPone.getName());
                    System.out.println("IT IS THE PHONE NUMBER: " + sPone.getNumber());
                    System.out.println();
                    break;
                case 564738292:
                    sPone.receiveCall(sPone.getName());
                    System.out.println("IT IS THE PHONE NUMBER: " + sPone.getNumber());
                    System.out.println();
                    break;
            }
        }
    }
}