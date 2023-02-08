public class SinglyLinkedDeque<ItemType> implements Deque<ItemType> {
    // private helper classes
    private class Node {
        ItemType data;
        Node next;
    }

    // fields
    private Node head;
    private int size;

    /**
     * Constructor: creates an empty deque of size 0
     */
    public SinglyLinkedDeque() {
        head = null;
        size = 0;
    }

    /**
     * Return the number of items in the deque
     *
     * @return number of items in the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds an item to the front of the deque.
     *
     * @param item item to be added
     */
    @Override
    public void addFirst(ItemType item) {
        // consider the case of adding to an empty list
        if(head == null) {
            head = item;
            size++;
        }
        // consider the case of adding to a non-empty list
        else {
            item.next = head;
            head = item;
            size++;
        }
    }

    /**
     * Adds an item to the back of the deque.
     *
     * @param item item to be added
     */
    @Override
    public void addLast(ItemType item) {
        Node current = head;
        // consider the case of adding to an empty list
        if (head == null) {
            head = item;
            size++;
        }
        // consider the case of adding to a non-empty list
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = item;
            size++;
        }
    }

    /**
     * Remove and return the item from the front, does nothing if empty.
     *
     * @return item at the front that was just removed, or null if empty
     */
    @Override
    public ItemType removeFirst() {
        // check if empty
        if (size == 0) {
            // if empty: do nothing and return null
            return null;
        }

        // if there's only one item: is this a special case?
        if(size == 1) {
            size--;
            head = null;
            return null;
        }
        // if not empty:
        if(size != 0) {
            // 0. figure out a way to access the item in the front
            // 1. make a variable to save a copy of the item at the front
            Node temp = head;
            // 2. remove the item at the front
            head = head.next;
            size--;
            // 3. return the variable that has the saved copy of the item at the front
            return temp;
        }

        return null;
    }

    /**
     * Remove and return the item from the back, does nothing if empty.
     *
     * @return item at the back that was just removed, or null if empty
     */
    @Override
    public ItemType removeLast() {
        // check if empty
        // if empty: do nothing and return null
        if(size == 0) {
            return null;
        }
        // if there is only one item: is this a special case?
        if(size == 1) {
            size = 0;
            head = null;
            return null;
        }
        // if not empty, has more than one item:
        if(size > 1) {
            // 0. figure out a way to access the item in the back
            // 1. make a variable to save a copy of the item at the back
            temp = head;
            while(temp.next != null) {
                temp = temp.next;
                // 2. remove the item at the back
                if(data.next == null) {
                    data = null;
                }
            }
            // 3. return the variable that has the saved copy of the item at the back
            return temp;
        }

        return null;
    }
}
