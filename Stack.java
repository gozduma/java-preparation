package test;
import java.util.Scanner;
public class Stack {
    private int mSize;
    private int[] stackArray;
    private int top;

    public Stack (int m){
        mSize = m;
        stackArray = new int[mSize];
        top = -1;
    }
    public void addElement(int element){
        stackArray[++top] = element;
    }
    public int deleteElement(){
        return stackArray[top--];
    }
    public int readTop(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top == mSize-1);
    }
}
class TesterStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("size Stack :");
        int m = scanner.nextInt();
        Stack stack = new Stack(m);
        stack.addElement(22);
        stack.addElement(1);
        stack.addElement(-100);
        stack.addElement(11);
        stack.deleteElement();
        System.out.printf("Stack :");
        while (!stack.isEmpty()){
            int value = stack.deleteElement();
            System.out.println(value);
        }
    }
}
