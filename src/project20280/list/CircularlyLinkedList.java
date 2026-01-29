package project20280.list;

import java.util.Iterator;

import project20280.interfaces.List;

public class CircularlyLinkedList<E> implements List<E> {

    private class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            data = e;
            next = n;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private  Node<E> tail = null;
    private  int size = 0;

    public CircularlyLinkedList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        Node<E> node = tail.next;

        for (int j = 0; j < i; j++)
        {
            node = node.next;
        }
        return node.getData();
    }

    /**
     * Inserts the given element at the specified index of the list, shifting all
     * subsequent elements in the list one position further to make room.
     *
     * @param i the index at which the new element should be stored
     * @param e the new element to be stored
     */
    @Override
    public void add(int i, E e) {
        Node<E> newNode = new Node<>(e, null);

        if (size == 0) {
            // first node points to itself
            newNode.next = newNode;
            tail = newNode;
        } else if (i == 0) {
            // insert at head
            newNode.next = tail.next; // tail.next is head
            tail.next = newNode;
        } else {
            // insert at position i
            Node<E> cur = tail.next; // start from head
            for (int j = 0; j < i - 1; j++) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;

            // update tail if inserting at the end
            if (i == size) {
                tail = newNode;
            }
        }

        size++;

    }

    @Override
    public E remove(int i) {
        Node<E> removedNode;
        if (size == 0) {return  null;}
        if (i == 0) {
            // Remove head
            removedNode = tail.next; // head
            if (size == 1) {
                // Only one node
                tail = null;
            } else {
                tail.next = removedNode.next;
            }
        } else {
            // Remove node at position i > 0
            Node<E> prev = tail.next; // start from head
            for (int j = 0; j < i - 1; j++) {
                prev = prev.next;
            }
            removedNode = prev.next;
            prev.next = removedNode.next;

            // Update tail if removing last node
            if (removedNode == tail) {
                tail = prev;
            }
        }

        removedNode.next = null; // optional cleanup
        size--;
        return removedNode.getData();
    }

    public void rotate() {
        tail = tail.next;
    }

    private class CircularlyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) tail;

        @Override
        public boolean hasNext() {
            return curr != tail;
        }

        @Override
        public E next() {
            E res = curr.data;
            curr = curr.next;
            return res;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<E>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E removeFirst() {
        return  remove(0);
    }

    @Override
    public E removeLast() {
        return  remove(size - 1);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = tail;
        do {
            curr = curr.next;
            sb.append(curr.data);
            if (curr != tail) {
                sb.append(", ");
            }
        } while (curr != tail);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
        for (int i = 10; i < 20; ++i) {
            ll.addLast(i);
        }

        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        ll.rotate();
        System.out.println(ll);

        ll.removeFirst();
        ll.rotate();
        System.out.println(ll);

        ll.removeLast();
        ll.rotate();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }

    }
}
