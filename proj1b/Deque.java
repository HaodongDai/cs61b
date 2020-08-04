interface Deque<T> {
    //* add an item to the front */
    void addFirst(T item);

    //* add an item to the back */
    void addLast(T item);

    //* remove an item from the front and return it */
    T removeFirst();

    //* remove an item from the back and return it */
    T removeLast();

    //* return boolean true if the deque is empty */
    boolean isEmpty();

    //* print all the elements in deque */
    void printDeque();

    //* return the size of the deque */
    int size();


}
