package util.ArrayQueue;

import mambutu.Exceptions.EmptyCollectionException;

public class CircularArrayQueue<T> implements QueueADT<T> {
    private final int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    public CircularArrayQueue() {
        front = rear = count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = ((T[]) (new Object[initialCapacity]));
    }

    public void enqueue(T element) {
        if (size() == queue.length)
            expandCapacity();

        queue[rear] = element;

        rear = (rear + 1) % queue.length;

        count++;
    }

    public T dequeue() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        T result = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;

        count--;

        return result;
    }

    public T first() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        return queue[front];
    }

    public T last() {
        return queue[rear];
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }


    public String toString() {
        String result = "";
        int scan = 0;

        while (scan < count) {
            if (queue[scan] != null) {
                result += queue[scan].toString() + "\n";
            }
            scan++;
        }

        return result;

    }

    public void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);

        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = count;
        queue = larger;
    }
}

