package test;

public class DoubleLinkedList {
    private Node2 head;
    private Node2 tail;

    public DoubleLinkedList(){
        head = null;
        tail = null;
    }

    private boolean isEmpty(){
        return (head == null);
    }

    public void addFirst(int data){
        Node2 temp = new Node2(data);
        if (isEmpty()){
            tail = temp;
        }
        else{
            head.prev = temp;
        }
        temp.next = head;
        head = temp;
    }

    public void addLast(int data){
        Node2 temp = new Node2(data);
        if (isEmpty()){
            head = temp;
        }
        else{
            tail.next = temp;
        }
        temp.prev = tail;
        tail = temp;
    }

    public void removeFirst(){
        if (head.next == null){
            tail = null;
        }
        else{
            head.next.prev = null;
        }
        head = head.next;
    }

    public void removeLast(){
        if (head.next == null){
            head = null;
        }
        else{
            tail.prev.next = null;
        }
        tail = tail.prev;
    }

    public void addByIndex(int data, int index){
        Node2 current = head;
        int c = 0;
        while(current != null && c != index){
            current = current.next;
            c++;
        }
        Node2 temp = new Node2(data);
        current.prev.next = temp;
        temp.prev = current.prev;
        current.prev = temp;
        temp.next = current;
    }

    public void removeByIndex(int index){
        Node2 current = head;
        int c = 0;
        while (c != index){
            current = current.next;
            c++;
        }
        if (c == 0){
            removeFirst();
        }
        else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

    }
    public void print(){
        Node2 temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
class Node2{
    public int data;
    public Node2 next;
    public Node2 prev;

    public Node2(int data){
        this.data = data;
    }
}

class Test3{
    public static void main(String[] args) {
        DoubleLinkedList mylst = new DoubleLinkedList();
        mylst.addFirst(2);
        mylst.addFirst(3);
        System.out.println();
        mylst.print();

        mylst.addLast(5);
        mylst.addLast(6);
        System.out.println();
        mylst.print();

        mylst.removeFirst();
        System.out.println();
        mylst.print();

        mylst.removeLast();
        System.out.println();
        mylst.print();

        mylst.addByIndex(10,1);
        System.out.println();
        mylst.print();

        mylst.removeByIndex(0);
        System.out.println();
        mylst.print();
    }
}