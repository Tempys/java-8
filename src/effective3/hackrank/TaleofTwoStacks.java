package effective3.hackrank;

import java.util.Scanner;

public class TaleofTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();


        queue.enqueue(14);
        queue.dequeue();
        queue.enqueue(14);
        System.out.println(queue.peek());
        queue.enqueue(28);
        System.out.println(queue.peek());
        queue.enqueue(60);
        queue.enqueue(78);
    /*    Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();*/
    }
}


class MyQueue<T> {

    private Node<Integer> stack;

    private Node<Integer> reverseStack;

    public void enqueue(int item){

        if(stack == null){
            reverseStack=stack= new Node(item,null);
        } else {
             Node<Integer> next = new Node<>(item,null);
             stack.next = next;
             stack = next;
        }


    };

    public Integer dequeue() {
        Node<Integer> node = reverseStack;
        reverseStack = reverseStack.next;
        if(reverseStack == null) stack = null;

        return node.item;
    };
    public Integer peek() {return reverseStack.item;};

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item,Node<T> next) {
            this.item = item;
            this.next = next;
        }


        public T getItem() {
            return item;
        }
    }
}