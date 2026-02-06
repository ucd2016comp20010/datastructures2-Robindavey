package project20280.list;

import java.util.Iterator;

import project20280.interfaces.List;

public class DoublyLinkedList<E> implements List<E> {

    private static class Node<E> {
        private final E data;
        private Node<E> next;
        private  Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

    }

    private  Node<E> head;
    private  Node<E> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.next = tail;
    }

    private void addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newNode = new Node<E>(e, null, null);
        pred.next = newNode;
        newNode.next = succ;
        succ.prev = newNode;
        newNode.prev =succ;
        size++;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0 && head.next == tail)
        {return true;}

        return false;
    }

    @Override
    public E get(int i) {
        if (i == size)
        {
            i--;
        }
        Node<E> cur = head;
        for (int pos = 0; pos < i+1; pos++) {
            cur = cur.getNext();
        }
        return cur.getData();
    }

    @Override
    public void add(int i, E e) {
        Node<E> cur = head;
        
        for (int pos = 0; pos < i; pos++) {
            cur = cur.next;
        }
        
        Node<E> succ = cur.next;
        Node<E> newNode = new Node<>(e, cur, succ);
        
        cur.next = newNode;
        succ.prev = newNode;
        
        size++;
    }


    @Override
    public E remove(int i) {
        Node<E> cur = head.next;
        
        for (int j = 0; j < i; j++) {
            cur = cur.next;
        }
        
        Node<E> pred = cur.prev;
        Node<E> succ = cur.next;
        
        pred.next = succ;
        succ.prev = pred;
        
        size--;
        return cur.getData();
    }
    private class DoublyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head.next;

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
        return new DoublyLinkedListIterator<E>();
    }

    private E remove(Node<E> n) {
        // TODO
        return null;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.next.getData();
    }

    public E last() {
        return get(size);
    }

    @Override
    public E removeFirst() {
        // TODO
        return remove(0);
    }

    @Override
    public E removeLast() {
        // TODO
        return remove(size-1);
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head.next;
        while (curr != tail) {
            sb.append(curr.data);
            curr = curr.next;
            if (curr != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(-1);
        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }
    }
}