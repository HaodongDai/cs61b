//* Array based Deque */
public class ArrayDeque<T> {
    //* Declare variables */
    private int size; //size of array
    private T[] array;
    private int nextFirst; //front pointer
    private int nextLast; //back pointer
    private double usage; //keeping track of the usage
    //public int arrayCapacity; //the array length instead of size

    //* Create an empty ArrayDeque */
    public ArrayDeque() {
        //The initial array length should be 8, but the size is 0
        size = 0;
        array = (T[]) new Object[8]; //this generic syntax is different
        nextFirst = array.length - 1;
        // nextFirst pointer is always at the end of the array moving leftwards
        nextLast = 0;
        //nextLast pointer is always at the start of the array moving rightwards
        usage = 0; // the usage ratio of the array
        //arrayCapacity = 8; //array length, initial length is 8
    }

    /** return the index immediately before the given index
     *  ie. if the index is 0, then this should return the index of the last position
     *      in the array
     * */
    private int minusOne(int index, int capacity) {
        if (index == 0) {
            return capacity - 1;
        } else {
            return index - 1;
        }
    }

    /** return the index immediately after the given index
     *  ie. if the index is 7, then this should return the index of the first position
     *      in the array (0)
     * */
    private int plusOne(int index, int capacity) {
        if (index == capacity - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    //* resize the array to the desired size */
    private void resizeHelper(int newCapacity) {
        int capacity = array.length;
        int start = plusOne(nextFirst, capacity);
        int end = minusOne(nextLast, capacity);
        T[] tempArray = array;
        array = (T[]) new Object[newCapacity];
        nextFirst = array.length - 1;
        nextLast = 0;
        //* the items in array are always on the right hand side of start point (first item) */
        // no out-of-bound error because of the circular array structure
        for (int i = start; i != end; i = plusOne(i, capacity)) {
            array[nextLast] = tempArray[i];
            nextLast = plusOne(nextLast,newCapacity);
        }
        array[nextLast] = tempArray[end];
        nextLast = plusOne(nextLast,newCapacity);
        //arrayCapacity = newCapacity;
    }

    private void resize() {
        //expand
        int capacity = array.length;
        if (size == capacity) {
            resizeHelper(capacity * 2);
        }

        //decrease when usage is very low and the array length is larger than 16
        if (usage < 0.25 && capacity > 16) {
            resizeHelper(capacity / 2);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void printDeque() {
        int start = plusOne(nextFirst,array.length);
        int end = minusOne(nextLast,array.length);
        for (int i = start; i != end; i = plusOne(i,array.length)) {
            System.out.print(array[i] + " ");
        }
        if (array[end] != null) {
            System.out.print(array[end]);
        }
    }

    public void addFirst(T item) {
        usage = size * 1.0 / array.length;
        resize();

        array[nextFirst] = item;
        //the array length may be modified after the resize operation
        nextFirst = minusOne(nextFirst,array.length);
        size += 1;
    }

    public void addLast(T item) {
        usage = size * 1.0 / array.length;
        resize();

        array[nextLast] = item;
        //the array length may be modified after the resize operation
        nextLast = plusOne(nextLast,array.length);
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int index = plusOne(nextFirst,array.length);
        T ret = array[index];
        array[index] = null;
        nextFirst = index;
        size -= 1;
        usage = size * 1.0 / array.length;
        resize();

        return ret;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int index = minusOne(nextLast,array.length);
        T ret = array[index];
        array[index] = null;
        nextLast = index;
        size -= 1;
        usage = size * 1.0 / array.length;
        resize();

        return ret;
    }

    public T get(int x) {
        if (x < 0 || x > array.length - 1) {
            return null;
        }

        int index = (nextFirst + x + 1) % array.length;
        return array[index];
    }

    //* helper function for getting the array length instead of size */
    public int getArrayLength() {
        return array.length;
    }

}
