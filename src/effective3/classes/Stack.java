package effective3.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class Stack<E> {

    private List<E> list;


    public void push(List<? super E> data){

    }


    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        List<Number> list = new ArrayList<>();
        stack.push(list);

        List<ScheduledFuture<?>> scheduledFutures = new ArrayList<>();
    }
}
