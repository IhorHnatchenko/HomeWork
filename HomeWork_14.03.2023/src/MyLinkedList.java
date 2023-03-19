public class MyLinkedList {

    private Node head;

    public void pushLikeArray(int i, int index) {
        int size = -1;
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            return;
        }
        Node last = head;
        while (size != index){
            size++;
            last = last.getNext();
        }
        last.setNext(node);
/*        for (size = -1; size < sizeMyLinkedList(); ++size) {
            if (size == index) {
                last.setNext(node);
            }
            last = last.getNext();
        }*/
        //last.setNext(node);
    }

    public void pushToTail(int i) {
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            return;
        }
        Node last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(node);

    }

    public void pushToStart(int i) {
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print("|" + curr.getData() + "| ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public int sizeMyLinkedList() {
        int size = 0;
        if (head == null) {
            return 0;
        }
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.getNext();
        }
        return size;
    }

    public int sizeMyLinkedListLikeArray() {
        int size = -1;
        if (head == null) {
            return -1;
        }
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.getNext();
        }
        return size;
    }

    public int getDataForIndex(int index) {
        int size = -1;
        if (head == null || index >= sizeMyLinkedList() || index < 0) {
            return -1;
        }
        Node curr = head;
        while (curr != null) {
            size++;
            if (size == index) {
                return curr.getData();
            }
            curr = curr.getNext();
        }
        return -1;
    }


}
