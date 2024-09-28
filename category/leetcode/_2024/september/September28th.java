package category.leetcode._2024.september;

public class September28th {

    private final int[] deque;
    private final int k;
    private int size;
    private int front;
    private int rear;

    public September28th(final int k) {
        this.deque = new int[k];
        this.k = k;
        this.size = 0;
        this.front = 0;
        this.rear = k - 1;
    }

    public boolean insertFront(final int value) {
        if (isFull()) {
            return false;
        }

        front = (--front + k) % k;
        deque[front] = value;
        size++;

        return true;
    }

    public boolean isFull() {
        return size == k;
    }

    public boolean insertLast(final int value) {
        if (isFull()) {
            return false;
        }

        rear = ++rear % k;
        deque[rear] = value;
        size++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = ++front % k;
        size--;

        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        rear = (--rear + k) % k;
        size--;

        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }
}
