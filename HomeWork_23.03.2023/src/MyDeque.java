public interface MyDeque {

    void addToHead(Integer element);

    void addToTail(Integer element);

    Integer removeHead();

    Integer removeTail();

    Integer peakHead();

    Integer peakTail();

    boolean isEmpty();

    boolean contains(Integer element);
}
