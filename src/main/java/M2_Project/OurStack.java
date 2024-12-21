package M2_Project;

import java.util.Stack;

public class OurStack<T> implements StackInterface<T> {
    private Stack<T> stack;

    public OurStack() {
        this.stack = new Stack<>();
    }

    @Override
    public void push(T item) {
        stack.push(item);
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public T peek() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
