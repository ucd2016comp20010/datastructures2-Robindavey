package project20280.stacksqueues;

import project20280.interfaces.Queue;
import project20280.list.CircularlyLinkedList;
/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */
public class LinkedCircularQueue<E> implements Queue<E> {
    private CircularlyLinkedList<E> cl;


    public LinkedCircularQueue()
    {
        this.cl = new CircularlyLinkedList<E>();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        return cl.size();
    }

    @Override
    public boolean isEmpty() {
        return cl.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        cl.addLast(e);
    }

    @Override
    public E first() {
        return cl.get(0);
    }

    @Override
    public E dequeue() {
        return cl.removeFirst();
    }
    @Override
    public String toString()
    {
        return cl.toString();
    }
}
