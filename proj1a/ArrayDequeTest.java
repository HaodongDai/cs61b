//* Performs some basic ArrayDeque Test */
public class ArrayDequeTest {

    //* Test whether the instantiated arraydeque is empty or not */
    public static void isEmptyTest1() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        if (A.isEmpty() == true) {
            System.out.println("isEmptyTest1 passed");
        } else {
            System.out.println("isEmptyTest2 failed");
        }
    }

    //* Test whether the arraydeque is empty after some items are added */
    public static void isEmptyTest2() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addLast(2);
        if (A.isEmpty() == false) {
            System.out.println("isEmptyTest2 passed");
        } else {
            System.out.println("isEmptyTest2 failed");
        }
    }

    //* Test the addFirst and addLast methods without exceeding its length limit */
    public static void addTest() {
        ArrayDeque<Integer> A = new ArrayDeque<>(); //the initial length is 8
        int i = 0;
        while (i < 7) {
            A.addLast(i+1);
            i += 1;
        }
        A.addFirst(0);
        System.out.println("The expected arraydeque is 0 1 2 3 4 5 6 7, and the actual arraydeque is");
        A.printDeque();
    }

    //* Test the removeFirst and removeLast methods without usage ratio lower than 0.25 */
    public static void removeTest() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        // Filling items from 0 to 7, the array should be 0 1 2 3 4 5 6 7
        int i = 0;
        while (i < 7) {
            A.addLast(i+1);
            i += 1;
        }
        A.addFirst(0);

        A.removeFirst();
        A.removeFirst();
        A.removeLast();
        A.removeLast();
        System.out.println("\n" + "The expected arraydeque is 2 3 4 5, and the actual arraydeque is");
        A.printDeque();
    }

    //* Test the addFirst, addLast and resize methods when the size exceeds the array length limit  */
    public static void testAddResize() {
        ArrayDeque<Integer> A = new ArrayDeque<>(); //the initial length is 8
        int i = 0;
        while (i < 7) {
            A.addLast(i+1);
            i += 1;
        }
        A.addFirst(0);
        //now the array is 0 1 2 3 4 5 6 7, and the arraydeque is full and needs to be expanded
        A.addFirst(-1);
        A.addLast(8);
        A.addLast(9);
        A.addFirst(-2);

        System.out.println("\n" + "the expected arraydeque is -2 -1 0 1 2 3 4 5 6 7 8 9, and the actual arraydeque is");
        A.printDeque();
    }

    //Test the removeFirst, removeLast and resize method when the usage is lower than 0.25 */
    public static void testRemoveResize() {
        System.out.println("\n" + "Remove and resize test starts:");
        ArrayDeque<Integer> A = new ArrayDeque<>();
        int i = 0;
        while (i < 32) {
            A.addLast(i);
            i += 1;
        }
        System.out.println("The arraydeque before removal is:");
        A.printDeque();
        System.out.println("\n" + "The arraydeque length is: " + A.getArrayLength());
        int lengthBefore = A.getArrayLength();
        //now the arraydeque is from 0 to 31 (32 items)
        //remove 25 items in this array to make its usage ratio lower than 25%
        for (int j = 0; j < 25; j ++) {
            A.removeLast();
        }
        System.out.println("\n" + "Now the arraydeque after removing 25 items is:");
        A.printDeque();
        System.out.println("\n" + "The arraydeque length is: " + A.getArrayLength());
        int lengthAfter = A.getArrayLength();
        System.out.println("\n" + "The arraydeque size is: " + A.size());

        if (lengthAfter == lengthBefore / 2) {
            System.out.println("testRemoveResize passed");
        } else {
            System.out.println("testRemoveResize failed");
        }
    }

    //*Test whether get() method works properly */
    public static void testGet() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        int i = 0;
        while (i < 8) {
            A.addLast(i);
            i += 1;
        }
        System.out.println("The expected 0-th item is 0, and the item retrieved from get method is " + A.get(0));
        System.out.println("The expected 5-th item is 5, and the item retrieved from get method is " + A.get(5));
        for (int j = 0; j < 8; j ++) {
            if (j != A.get(j)) {
                System.out.println("Items don't match , error! ");
            }
        }
        System.out.println("get method test passed");
    }

    public static void main(String[] args) {
        isEmptyTest1();
        isEmptyTest2();
        addTest();
        removeTest();
        testAddResize();
        testRemoveResize();
        testGet();
    }
}
