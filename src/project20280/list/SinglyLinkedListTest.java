package project20280.list;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    @Test
    void testIsEmpty() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        Assertions.assertTrue(ll.isEmpty());
        Assertions.assertEquals("[]", ll.toString());

        ll.addLast(1);
        assertFalse(ll.isEmpty());

        ll.removeLast();
        Assertions.assertTrue(ll.isEmpty());
    }

    @Test
    void testGet() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        Integer r = ll.get(2);
        Assertions.assertEquals(3, r, "did not get right element" + r);
    }

    @Test
    void testAdd() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        ll.add(1, 100);

        Assertions.assertEquals("[1, 100, 2, 3]", ll.toString(), "item not added correctly");
    }

    @Test
    void testRemove() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        Assertions.assertEquals(3, ll.remove(2), "the removed value should be 3");
        Assertions.assertEquals(2, ll.size(), "the size should be 2");
    }

    @Test
    void testSize() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        Assertions.assertEquals(0, ll.size());

        ll.addFirst(1);
        Assertions.assertEquals(1, ll.size());

        ll.removeFirst();
        Assertions.assertEquals(0, ll.size());
    }

    @Test
    void testRemoveFirst() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
		Assertions.assertNull(ll.removeFirst());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        Integer r = ll.removeFirst();
        Assertions.assertEquals(1, r);
        Assertions.assertEquals(2, ll.size());
    }

    @Test
    void testRemoveLast() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        Assertions.assertEquals(3, ll.removeLast());
        Assertions.assertEquals(2, ll.size());
    }

    @Test
    void testAddFirst() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(-1);
        ll.addFirst(1);

        Assertions.assertEquals(2, ll.size());
        Assertions.assertEquals("[1, -1]", ll.toString());
    }

    @Test
    void testAddLast() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addFirst(1);
        ll.addLast(-1);

        Assertions.assertEquals(2, ll.size());
        Assertions.assertEquals("[1, -1]", ll.toString());
    }

    @Test
    void testToString() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        Assertions.assertEquals("[1, 2, 3]", ll.toString());
    }

}
