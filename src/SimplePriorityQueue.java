public class SimplePriorityQueue {

    private static final int DEFAULT_INSTANCE = 10;

    // size is pointing to next empty cell
    int size;
    Integer[] array;

    public SimplePriorityQueue() {
        this(DEFAULT_INSTANCE);
    }

    public SimplePriorityQueue(int capacity) {
        size = 0;
        array = new Integer[capacity];
    }

    // Heapify
    public SimplePriorityQueue(Integer[] elements) {
        if (elements == null) {
            return;
        }
        size = elements.length;
        array = elements;
        // First non-leaf node index
        int index = getParent(size - 1);
        while (index >= 0) {
            shiftDown(index);
            index--;
        }
    }

    public void offer(Integer e) {
        if (isFull()) {
            resize(array.length * 2);
        }
        array[size] = e;
        shiftUp(size);
        size++;
    }

    private void resize(int newCapacity) {
        Integer[] newArray = new Integer[newCapacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public Integer poll() {
        doEmptyCheck();
        int root = array[0];
        swap(0, size - 1);
        array[size - 1] = null;
        size--;
        shiftDown(0);
        return root;
    }

    public Integer peek() {
        doEmptyCheck();
        return array[0];
    }

    public int size() {
        System.out.println(size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void shiftUp(int cur) {
        while (cur > 0) {
            if (array[cur] < array[getParent(cur)]) {
                swap(cur, getParent(cur));
                cur = getParent(cur);
            } else {
                break;
            }
        }
    }
    private void shiftDown(int cur) {
        while (cur < size) {
            int left = getLeftChild(cur);
            int right = getRightChild(cur);
            if (left < size && right < size) {
                int minIndex = (array[left] < array[right]) ? left : right;
                if (array[cur] > array[minIndex]) {
                    swap(cur, minIndex);
                    cur = minIndex;
                } else {
                    break;
                }
            } else if (left < size && right > size && array[cur] > array[left]){
                swap(cur, left);
                cur = left;
            } else {
                break;
            }

        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int left, int right) {
        Integer temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private void doEmptyCheck() {
        if (isEmpty()) {
            throw new IllegalArgumentException("no element in this LoopArray");
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        SimplePriorityQueue pq = new SimplePriorityQueue(new Integer[] {8,7,10,9,11});
        pq.offer(1);
        pq.offer(3);
        pq.offer(6);
        pq.offer(2);
        pq.offer(4);
        pq.offer(5);
        pq.print();


        System.out.println("current min value: " + pq.poll());
        //pq.print();
        System.out.println("current min value: " + pq.poll());
        //pq.print();
        System.out.println("current min value: " + pq.poll());
        //pq.print();
        System.out.println("current min value: " + pq.poll());
        //pq.print();
        System.out.println("current min value: " + pq.poll());
        //pq.print();
        System.out.println("current min value: " + pq.poll());
        //System.out.println("current min value: " + pq.poll());
    }
}

