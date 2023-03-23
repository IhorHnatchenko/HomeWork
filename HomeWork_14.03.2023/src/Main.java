import java.util.*;

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


        List<Node> integers = new ArrayList<>();
        myLinkedList.castLinkedListToList(integers);
        System.out.println("Print my linked list like ArrayList: ");
        for(int i = 0; i < myLinkedList.sizeMyLinkedList(); i++){
            System.out.print("|" + integers.get(i) + "| ");
        }

        Iterator<Node> iterator = integers.iterator();
        System.out.println("\nPrint my liked list by iterator: ");
        while (iterator.hasNext()){
            System.out.print("|" + iterator.next() + "| ");
        }

        ListIterator<Node> listIterator = integers.listIterator();
        System.out.println("\nPrint my liked list by list iterator: ");
        while (listIterator.hasNext()){
            System.out.print("|" + listIterator.next() + "| ");
        }
        System.out.println();


        System.out.println("\nSize of my linked list = " + myLinkedList.sizeMyLinkedList());

        System.out.println("Size of my linked list like a array = " + myLinkedList.sizeMyLinkedListLikeArray());

        System.out.print("Enter index for print data by this index: ");
        index = scanner.nextInt();
        System.out.print("Get data for index " + index + ": ");
        System.out.println(myLinkedList.getDataForIndex(index));
        System.out.println();

        myLinkedList.printList();
        System.out.print("Enter index for add: ");
        int indexForAdd = scanner.nextInt();
        System.out.print("Enter data for add: ");
        int numberForAddInIndex = scanner.nextInt();
        myLinkedList.pushByIndex(numberForAddInIndex, indexForAdd);
        myLinkedList.printList();
        System.out.println();

        System.out.print("Enter index for remove: ");
        int numberForRemoveByIndex = scanner.nextInt();
        myLinkedList.removeByIndex(numberForRemoveByIndex);
        myLinkedList.printList();
        System.out.println();

        System.out.print("Enter data for remove: ");
        int numberForRemoveByData = scanner.nextInt();
        myLinkedList.removeByData(numberForRemoveByData);
        myLinkedList.printList();
        System.out.println();





    }


}