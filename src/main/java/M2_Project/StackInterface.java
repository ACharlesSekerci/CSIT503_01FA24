package M2_Project;

// Step 1: Start - Define StackInterface
public interface StackInterface<T> {
    void push(T item);

    T pop();

    T peek();

    boolean isEmpty();

    int size();
}
