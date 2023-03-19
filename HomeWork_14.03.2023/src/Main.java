import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index;
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.pushToStart(3);
        myLinkedList.pushToStart(4);
        myLinkedList.pushToStart(5);
        myLinkedList.pushToStart(6);

        myLinkedList.pushToTail(7);
        myLinkedList.pushToTail(8);
        myLinkedList.pushToTail(9);
        myLinkedList.pushToTail(10);

        System.out.println("My linked list: ");
        myLinkedList.printList();
        System.out.println();

        System.out.println("Size of my linked list = " + myLinkedList.sizeMyLinkedList());

        System.out.println("Size of my linked list like a array = " + myLinkedList.sizeMyLinkedListLikeArray());

        System.out.print("Enter index: ");
        //index = scanner.nextInt();
        //System.out.print("Get data for index " + index + ": ");
        //System.out.println(myLinkedList.getDataForIndex(index));
        System.out.println();

        myLinkedList.printList();
        myLinkedList.pushLikeArray(11, 3);
        myLinkedList.printList();



    }


}