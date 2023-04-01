import java.util.List;

public class MyLinkedList {

    private Node head;

    private Node prev;

    public void removeByIndex(int index) {
        Node curr = head;
        Node prevNode = prev;

        for (int i = 0; i < sizeMyLinkedList(); i++) {
            if (i == index) {
                if (curr == head) {
                    head = curr.getNext();
                } else {
                    prevNode.setNext(curr.getNext());
                }
            }
            prevNode = curr;
            curr = curr.getNext();
        }

/*      int jump = 0;
        while (jump != sizeMyLinkedList()) {
            if (jump == index) {
                if(curr == head){
                    head = curr.getNext();
                }else {
                    prevNode.setNext(curr.getNext());
                }
            }
            prevNode = curr;
            curr = curr.getNext();
            jump++;
        }*/
    }

    public void removeByData(int data) {
/*        Node node = new Node(i, null);
        Node curr = head;
        Node prev = null;
        int jump = 0;

        while (jump < index - 1) {
            curr = curr.getNext();
            jump++;
        }
        if(curr == head){
            head = curr.getNext();
        }else {
            prev.getNext() = curr.getNext();
        }
        */
        Node currentNode = head;
        Node previousNode = prev;

        while (currentNode != null) {

            if (currentNode.getData() == data) {
                if (currentNode == head) {
                    head = currentNode.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }
            }

            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    public void pushByIndex(int i, int index) {
        Node node = new Node(i, null);
        Node curr = head;
        int jump = 0;       //Если я хочу что бы элемент добалялся после индекса, а не вместо. То эту переменную нужно изменить на -1.
        while (jump < index - 1) {
            curr = curr.getNext();
            jump++;
        }
        node.setNext(curr.getNext());
        curr.setNext(node);
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

    public List<Node> castLinkedListToList(List<Node> integers) {
        Node curr = head;
        for (int i = 0; i < sizeMyLinkedList(); i++) {
            integers.add(curr);
            curr = curr.getNext();
        }
        return integers;
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

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}
