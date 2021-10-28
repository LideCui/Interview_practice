package DataStructures.StackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack {


}

/**
 * Design a stack which can pop min in constant time
 */
class StackWithMin extends Stack<Integer> {
    Stack<Integer> s2;
    public StackWithMin() {
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        if(value < min()){
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if( value == min()){
            s2.pop();
        }
        return value;
    }

    public int min() {
        if( s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return s2.peek();
        }
    }
}

/**
 * implement SetOfStacks data structure composed of serveral stacks and create a new stack once capacity exceeds
 */
class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (stacks.size()==0) return null;
        return stacks.get(stacks.size() -1);
    }

    public void push(int v) {
        Stack last = getLastStack();
        if (last != null && last.size() < capacity) {
            last.push(v);
        } else {
            Stack stack = new Stack();
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last != null) throw new EmptyStackException();
        int v = (int) last.pop();
        if (last.size() == 0) stacks.remove(stacks.size()-1);
        return v;
    }
}