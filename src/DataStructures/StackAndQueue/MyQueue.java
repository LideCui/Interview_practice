package DataStructures.StackAndQueue;

import java.util.Stack;

public class MyQueue {

}

/**
 * Implement Queue with two stacks
 */
class QueueByTwoStacks<T> {
    Stack<T> stackNew, stackOld;

    public QueueByTwoStacks() {
        stackNew = new Stack<T>();
        stackOld = new Stack<T>();
    }

    public void add(T value){
        stackNew.add(value);
    }

    private void shiftStacks(){
        if(stackOld.isEmpty()){
            while(!stackNew.isEmpty()){
                stackOld.push(stackNew.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOld.peek();
    }

    public T remove(){
        shiftStacks();
        return stackOld.pop();
    }
}