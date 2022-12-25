package test;

public class SingleLinkedListEasy {
    private LinkList head;
    private LinkList tail;

    public SingleLinkedListEasy(){
        head = null;
        tail = null;
    }

    private boolean isEmpty(){
        return (head == null);
    }

    public void addToStart(int data) {
        LinkList temp = new LinkList(data);
        if (isEmpty()) {
            tail = temp;
            temp.next = head;
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public void addToEnd(int data){
        LinkList temp = new LinkList(data);
        tail.next = temp;
        tail = temp;

    }
    public void removeToStart(){
        head = head.next;
    }
    public void removeToEnd(){
        tail = null;
    }

    public void removeAt(int key){
        LinkList cur = head;
        LinkList prev = head;
        while (cur.data != key ){
            if (isEmpty()){
                System.out.println("List is empty");
                return;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
            if (cur == head){
                head = head.next;
            }
            else{
                prev.next = cur.next;
            }
        }
    }

    public int find (int key){
        LinkList temp = head;
        int c =0;
        while (temp != null){
            if (temp.data == key){
                return c;
            }
            temp = temp.next;
            c++;
        }
        return -1;
    }
    public void print(){
        LinkList temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
class LinkList{
    public int data;
    public LinkList next;

    public LinkList(int data){
        this.data = data;
    }
}

class Test2{
    public static void main(String[] args) {
        SingleLinkedListEasy lst = new SingleLinkedListEasy();
        lst.addToStart(10);
        lst.addToStart(20);
        lst.addToStart(30);
        lst.print();

        System.out.println();
        lst.addToEnd(40);
        lst.print();

        System.out.println();
         lst.removeToStart();
         lst.print();

        System.out.println();
        lst.removeToEnd();
        lst.print();
    }
}