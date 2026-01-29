package project20280.list;
import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedList<E> implements List<E> {

    private static class Node<E> {

        private final E element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;         // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            this.element = e;
            setNext(n);       }

        // Accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }
        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            // TODO
            return next;
        }

        // Modifier methods

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    /**
     * The head node of the list
     */
    private Node<E> head = null;               // head node of the list (or null if empty)


    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    public SinglyLinkedList() {
    }              // constructs an initially empty list

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0  || head == null)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public E get(int position) {
        Node <E> cur = head;
        int pos = 0;
        while (cur.getNext() != null && pos < position)
        {
            cur = cur.getNext();
            pos++;
        }
        return cur.getElement();
    }

    @Override
    public void add(int position, E e) {
        Node <E> cur = head;
        int pos = 0;
        Node<E> newNode = new Node<E>(e, null);
        if (head == null)
        {
            head = newNode;
            size++;

        }
        while (cur != null && pos < position-1)
        {
            cur = cur.getNext();
            pos++;
        }
        newNode.setNext(cur.getNext());
        cur.setNext(newNode);
        size++;
    }


    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e, null);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e, null);
        Node<E> cur = head;
        if (head == null)
        {
            head = newNode;
            size++;

        }
        else {
            while (cur.next != null)
            {
                cur = cur.getNext();
            }
            cur.setNext(newNode);
            size++;
        }

    }

    @Override
    public E remove(int position) {
        Node<E> removedNode;

        if (position == 0) {
            // Remove head
            removedNode = head;
            head = head.getNext();
        } else {
            // Find the node just before the one to remove
            Node<E> prev = head;
            for (int i = 0; i < position - 1; i++) {
                prev = prev.getNext();
            }
            removedNode = prev.getNext();
            prev.setNext(removedNode.getNext());
        }

        removedNode.setNext(null); // clean up
        size--;
        return removedNode.getElement();
    }

    @Override
    public E removeFirst() {
        if (this.isEmpty())
        {
            return null;
        }
        E out = head.getElement();
        head=head.getNext();
        size--;
        return out;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null; // nothing to remove
        }

        if (size == 1) {
            // Only one element
            E out = head.getElement();
            head = null;
            size--;
            return out;
        }

        // More than one element
        Node<E> cur = head;
        for (int i = 0; i < size - 2; i++) {
            cur = cur.getNext();
        }

        // cur is now the second-to-last node
        E out = cur.getNext().getElement();
        cur.setNext(null); // remove last node
        size--;
        return out;
    }

    //@Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E res = curr.getElement();
            curr = curr.next;
            return res;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.getElement());
            if (curr.getNext() != null)
                sb.append(", ");
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
    public boolean contains(Objects o)
    {
        Node<E> cur = head;
        while (cur.next != null)
        {
            if (cur.getElement().equals(o))
            {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        SinglyLinkedList<E> smallList = new SinglyLinkedList<E>();
        Node<E> cur = head;
        int pos = 0;
        while (cur.getNext() != null && pos < toIndex)
        {
            smallList.addLast(cur.getElement());
            cur = cur.getNext();
        }
        return smallList;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
        System.out.println("ll " + ll + " isEmpty: " + ll.isEmpty());
        //LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(-1);
        ll.add(2, 3);
        //ll.removeLast();
        //ll.removeFirst();
        //System.out.println("I accept your apology");
        //ll.add(3, 2);
        System.out.println(ll);
        ll.remove(5);
        System.out.println(ll);

    }
}
