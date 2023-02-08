public class ResizingArrayDeque<ItemType> implements Deque<ItemType> {
    // constants
    public static int DEFAULT_CAPACITY = 10;

    // fields
    private ItemType[] data;
    private int size;

    /**
     * Constructor: creates an empty deque of size 0
     */
    public ResizingArrayDeque() {
        data = (ItemType[])new Object[DEFAULT_CAPACITY];
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
        if(size == 0) {
            data = item;
            size++;
        }
        // consider the case of adding to a non-empty list
        if(size != 0){
            ItemType temp;
            while(data.next != null) {
                temp = data.next;
                data.next = data;
            }
            data = item;
            size++;
        }
        // There is a private helper method checkSize() defined below to check/resize
        // that you can call as needed to check if the array is full and resize it.
        checkSize();

    }

    /**
     * Adds an item to the back of the deque.
     *
     * @param item item to be added
     */
    @Override
    public void addLast(ItemType item) {
        // consider the case of adding to an empty list
        if(size == 0) {
            data = item;
        }
        // consider the case of adding to a non-empty list
        if(size != 0) {
            ItemType temp;
            while(data.next != null) {
                temp = data.next;
            }
            temp.next = item;
            size++;
        }
        // There is a private helper method checkSize() defined below to check/resize
        // that you can call as needed to check if the array is full and resize it.
        checkSize();
    }

    /**
     * Remove and return the item from the front, does nothing if empty.
     *
     * @return item at the front that was just removed, or null if empty
     */
    @Override
    public ItemType removeFirst() {
        // check if empty
        // if empty: do nothing and return null
        if(size = 0) {
            return null;
        }
        // if there's only one item: is this a special case?
        if(size == 1) {
            data = null;
            size--;
            return data;
        }
        // if not empty:
        if(size > 1) {
            // 0. figure out a way to access the item in the front
            // 1. make a variable to save a copy of the item at the front
            ItemType temp = data;
            // 2. remove the item at the front
            data = null;
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
            data = null;
            size--;
            return data;
        }
        // if not empty, has more than one item:
        if(size > 1) {
            // 0. figure out a way to access the item in the back
            // 1. make a variable to save a copy of the item at the back
            ItemType temp = data;
            while(data.next != null) {
                temp = data.next;
            }
            // 2. remove the item at the back
            if(data.next == null) {
                data = null;
                size--;
            }
            // 3. return the variable that has the saved copy of the item at the back
        }
        return null;
    }

    // helper method to check to see if the size has reached the capacity
    // and more space needs to be allocated (creates a new larger array
    // and copies items over)
    private void checkSize() {
        if (size == data.length) {
            // resize up (double up the array size)

            // Step 1 - create a new larger array
            ItemType[] temp = (ItemType[]) new Object[size * 2];

            // Step 2 - copy items from data to temp
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }

            // Step 3 - repoint/refererence data to point to new array
            data = temp;

            // Optional:
            temp = null;
        } // end of if (need to resize)
    }
}
