package test;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListStack<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T data) {
        linkedList.addFirst(data);
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}

class LinkedList<T> {

    // внутренний класс, который представляет элемент списка
    private static class Node<T> {

        // данные
        private T data;
        // указатель на следующий элемент
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> first = null;

    // используется для push операции
    public void addFirst(T data) {
        Node<T> newFirst = new Node<T>(data);
        newFirst.next = first;
        first = newFirst;
    }

    // используется для pop операции
    public T removeFirst() {
        Node<T> oldFirst = first;
        first = first.next;
        return oldFirst.data;
    }

    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(",");
            currentNode = currentNode.next;
        }
        return listBuilder.toString();
    }

    public boolean isEmpty() {
        return first == null;
    }

}


class TestLinkedListStack {

    List<Integer> testData;

    @Before
    public void init() {
        testData = Arrays.asList(600, 1200, 1500, 2100);
    }

    @Test
    public void testPushPop() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1200);
        stack.push(1500);
        assertEquals("1500,1200,", stack.toString());
        assertEquals(1500, (int) stack.pop());
        assertEquals("1200,", stack.toString());
    }

    @Test
    public void testPopIsEmpty() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
        for (Integer value : testData) {
            stack.push(value);
        }
        assertFalse(stack.isEmpty());
        for (int i = testData.size(); i > 0; --i) {
            assertEquals(testData.get(i - 1), stack.pop());
        }
    }

    @Test
    public void testPushIsEmpty() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
        for (Integer value : testData) {
            stack.push(value);
        }
        assertFalse(stack.isEmpty());

    }
}
