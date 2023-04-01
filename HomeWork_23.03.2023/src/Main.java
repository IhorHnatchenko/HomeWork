public class Main {
    public static void main(String[] args) {

        MyArrayDeque myArrayDeque = new MyArrayDeque(10);
        myArrayDeque.addToHead(1);
        myArrayDeque.addToHead(2);
        myArrayDeque.addToHead(3);
        myArrayDeque.addToHead(32);
        myArrayDeque.addToHead(12);

        //myArrayDeque.addToHead(99);

        myArrayDeque.addToTail(7);
        myArrayDeque.addToTail(44);
        myArrayDeque.addToTail(4);
        myArrayDeque.addToTail(66);
        myArrayDeque.addToTail(11);


        System.out.println(myArrayDeque.peakHead());
        System.out.println(myArrayDeque.peakTail());
        System.out.println(myArrayDeque.contains(66));

    }
}