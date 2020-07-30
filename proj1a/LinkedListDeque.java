//* Linked List Based Deque (circular linked list) */
public class LinkedListDeque<Type> {

    //* Defining the node with item, previous and next pointer */
    private class Node {
        //* Declare these three members */
        private Node prev;
        private Node next;
        private Type item;

        //* Constructor of Node */
        private Node(Node p, Type i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    //* Declare the size and sentinel variables */
    private int size;
    private Node sentinel;

    //* Constructor, creating an empty LinkedListDeque */
    public LinkedListDeque() {
        int size = 0;
        //* create a circular sentinel node */
        sentinel = new Node(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    //* add the given x (Type) to the front of the linked list */
    public void addFirst(Type x) {
        size += 1;
        Node first = new Node(sentinel,x,sentinel.next);
        sentinel.next = first;
        sentinel.next.next.prev = sentinel.next;
    }

    //* add the given x (Type) to the back of the deque */
    public void addLast(Type x) {
        size += 1;
        Node last = new Node(sentinel.prev, x, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
    }

    //* return True if this deque size is 0 */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    //* return the size of this deque */
    public int size() {
        return this.size;
    }

    //* prints the items in this deque from the first to the last one */
    public void printDeque() {
        Node node = sentinel;
        //* if the size is 0, this iteration will not be executed */
        while (node.next != sentinel) {
            System.out.print(node.next.item + " ");
            node = node.next;
        }
    }

    /* removes and return the first item in the deque, if it
     * does not exist, return null.
     */
    public Type removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Type first = sentinel.next.item;
            size -= 1;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            return first;
        }
    }

    /* removes and return the last item in the deque, if it
     * does not exist, return null.
     */
    public Type removeLast() {
        if (size == 0) {
            return null;
        } else {
            Type last = sentinel.prev.item;
            size -= 1;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            return last;
        }
    }

    //* get the i-th item using iteration */
    public Type get(int index) {
        if (size == 0 || index > size - 1) {
            return null;
        } else {
            Node node = sentinel.next; //this is actually the first item (index 0)
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.item;
        }
    }

    //* get the i-th item using recursion */
    public Type getRecursion(int index) {
        if (size == 0 || index > size - 1) {
            return null;
        } else {
            Node node = sentinel.next;
            Type item = recursive(node, index).item;
            return item;
        }
    }

    //* the helper function for getRecursion method */
    public Node recursive(Node n, int i) {
        if (i == 0) {
            return n;
        } else {
            return recursive(n.next,i - 1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1); //expected 1
        //L.printDeque();
        L.addFirst(2);
        L.printDeque();
        //System.out.println(L.size());
    }



}
