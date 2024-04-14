package model.queues;

import java.sql.SQLOutput;

public class Queue<T> implements IQueue<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    public Queue() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(final T elem) {
        elements[size++] = elem;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            return;
        }
        front = (front + 1) % elements.length;
        size--;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            return null;
        }
        return (T) elements[front];
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public IQueue<T> deepCopy() {
        IQueue<T> copy = new Queue<>();
        for (int i = 0; i < size; i++) {
            copy.enqueue((T) elements[(front + i) % elements.length]);
        }
        return copy;
    }

}
