import java.util.NoSuchElementException;

public class MyArrayDeque implements MyDeque {


    private Integer[] elements;
    private int numberOfElements;
    private int indexHead = 0;
    private int indexTail;

    private int MAX_SIZE = 200;

    public MyArrayDeque(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Integer[initialCapacity];
            indexTail = elements.length - 1;
        }
    }

    @Override
    public void addToHead(Integer element) {
        if (numberOfElements == elements.length) {
            grow();
            //throw new IllegalStateException("Deque is full.");
        }
        elements[indexHead] = element;
        indexHead++;
        numberOfElements++;
    }

    @Override
    public void addToTail(Integer element) {
        if (numberOfElements == elements.length) {
            grow();
            //throw new IllegalStateException("Deque is full.");
        }
        elements[indexTail] = element;
        indexTail--;
        numberOfElements++;
    }

    private void grow() {
        int newCapacity = calculateNewCapacity(elements.length);
        growToNewCapacity(newCapacity);
    }

    private int calculateNewCapacity(int currentCapacity) {
        if (currentCapacity == MAX_SIZE) {
            throw new IllegalStateException("Can't grow further");
        }

        int newCapacity = currentCapacity + calculateAdditionalCapacity(currentCapacity);

        if (newCapacity > MAX_SIZE || newCapacity < 0) {
            newCapacity = MAX_SIZE;
        }

        return newCapacity;
    }

    private int calculateAdditionalCapacity(int currentCapacity) {
        return currentCapacity < 255 ? currentCapacity : (int) (currentCapacity / 1.75);
    }

    private void growToNewCapacity(int newCapacity) {
        Integer[] newArray = new Integer[newCapacity];

        int startIndex = elements.length / 2 + 1;
        System.arraycopy(elements, 0, newArray, 0, elements.length / 2 + 1);

        startIndex = newArray.length / 2 - indexHead - 1;
        if (indexTail > 0) {
            System.arraycopy(elements, elements.length / 2 + 2, newArray, newArray.length - elements.length / 2 + 2, elements.length / 2 + 2);
        }

        indexHead = startIndex;
        indexTail = newArray.length / 2 + indexTail;
        elements = newArray;
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
