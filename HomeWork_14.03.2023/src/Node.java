public class Node {
    private Integer data;

    private Node next;

    //private Node prev;

    public Node(Integer data, Node next/*, Node prev*/) {
        this.data = data;
        this.next = next;
        //this.prev = prev;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

/*    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }*/
}
