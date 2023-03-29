import java.util.NoSuchElementException;

public class MyArrayDeque implements MyDeque {

    private Integer[] elements;
    private int numberOfElements;
    private int indexHead = 0;
    private int indexTail;

    public MyArrayDeque(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Integer[initialCapacity];
            indexTail = elements.length - 1;
        }
    }

    @Override
    public void addToHead(Integer element) {
        if (numberOfElements == elements.length) {
/*            Integer temp[] = new Integer[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, indexHead);
            this.elements = temp;*/
            throw new IllegalStateException("Deque is full.");
        }
        elements[indexHead] = element;
        indexHead++;
        numberOfElements++;
    }

    @Override
    public void addToTail(Integer element) {
        if (numberOfElements == elements.length) {
/*            Integer temp[] = new Integer[elements.length * 2];
            System.arraycopy(elements, indexHead, temp, indexHead+1, elements.length-indexHead);
            this.elements = temp;*/
            throw new IllegalStateException("Deque is full.");
        }
        elements[indexTail] = element;
        indexTail--;
        numberOfElements++;
    }

    @Override
    public Integer removeHead() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }
        Integer integer = peakHead();
        elements[indexHead] = null;
        indexHead--;
        numberOfElements--;
        return integer;
    }

    @Override
    public Integer removeTail() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }
        Integer integer = peakTail();
        elements[indexTail] = null;
        indexTail++;
        numberOfElements--;
        return integer;
    }

    @Override
    public Integer peakHead() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }
        return elements[indexHead - 1];
    }

    @Override
    public Integer peakTail() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }
        return elements[indexTail + 1];
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean contains(Integer element) {
        int count = numberOfElements;
        while (count != 0) {
            if (element.equals(elements[indexHead]) || element.equals(elements[indexTail])) {
                return true;
            } else {
                if (indexHead == 0 || indexTail == numberOfElements) {
                    return false;
                } else {
                    indexHead--;
                    indexTail++;
                }
            }
            count--;
        }
        return false;
    }
}
