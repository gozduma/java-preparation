package test;

class Node
{
    int data;       // целочисленные данные
    Node next;      // указатель на следующий узел
}

public class Stack2
{
    private Node top;
    private int nodesCount;

    public Stack2() {
        this.top = null;
        this.nodesCount = 0;
    }

    // Вспомогательная функция для добавления элемента `x` в stack
    public void push(int x)        // вставляем в начало
    {
        // выделяем новый узел в куче
        Node node = new Node();

        // проверяем, заполнен ли Stack (heap). Тогда вставка элемента будет
        // привести к переполнению stack
        if (node == null)
        {
            System.out.println("Heap Overflow");
            return;
        }

        System.out.println("Inserting " + x);

        // устанавливаем данные в выделенном узле
        node.data = x;

        // устанавливаем указатель .next нового узла так, чтобы он указывал на текущий
        // верхний узел списка
        node.next = top;

        // обновить верхний указатель
        top = node;

        // увеличить размер stack на 1
        this.nodesCount += 1;
    }

    // Вспомогательная функция для проверки, пуст stack или нет
    public boolean isEmpty() {
        return top == null;
    }

    // Вспомогательная функция для возврата верхнего элемента stack
    public int peek()
    {
        // проверка на пустой stack
        if (isEmpty()) {
            System.out.println("The stack is empty");
            System.exit(-1);
        }
        return top.data;
    }

    // Вспомогательная функция для извлечения верхнего элемента из stack
    public int pop()        // удалить в начале
    {
        // проверка на опустошение stack
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }

        // принять к сведению данные верхнего узла
        int top = peek();

        System.out.println("Removing " + top);

        // уменьшить размер stack на 1
        this.nodesCount -= 1;

        // обновляем верхний указатель, чтобы он указывал на следующий узел
        this.top = (this.top).next;

        return top;
    }

    // Вспомогательная функция для возврата размера stack
    public int size() {
        return this.nodesCount;
    }
}

class Tester4
{
    public static void main(String[] args)
    {
        Stack2 stack = new Stack2();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("The top element is " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();

        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}