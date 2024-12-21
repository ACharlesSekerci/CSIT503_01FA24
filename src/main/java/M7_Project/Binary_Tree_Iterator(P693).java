package M7_Project;
import java.util.*;

/*********************************************
 * a. Diagram - GuessGame (Represented by interfaces/classes below)
 *********************************************/

// Page 668, Projects 1

/*********************************************
 * b. Diagram - BinaryTree<T>
 *********************************************/
class BinaryTree<T> {
    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void setRoot(TreeNode<T> node) {
        root = node;
    }

    public TreeNode<T> getRoot() {
        return root;
    }
}

/*********************************************
 * c. Diagram - TreeIterator<T>
 *********************************************/
interface TreeIterator<T> extends Iterator<T> {
    boolean hasNext();
    T next();
}

/*********************************************
 * d. Diagram - BinaryNode<T>
 *********************************************/
class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }
}

/*********************************************
 * e. Diagram - TreeIteratorInterface<T>
 *********************************************/
interface TreeIteratorInterface<T> {
    Iterator<T> getPreorderIterator();
    Iterator<T> getPostorderIterator();
    Iterator<T> getLevelOrderIterator();
}

/*********************************************
 * f. Diagram - DecisionTree<T>
 *********************************************/
class DecisionTree<T> extends BinaryTree<T> {
    public DecisionTree() {
        super();
    }
}

/*********************************************
 * g. Diagram - DecisionTreeInterface<T>
 *********************************************/
interface DecisionTreeInterface<T> extends TreeIteratorInterface<T> {
    // Additional decision tree specific methods could be added here
}

/*********************************************
 * h. Diagram - BinaryTreeInterface<T>
 *********************************************/
interface BinaryTreeInterface<T> extends TreeIteratorInterface<T> {
    void setTree(T rootData);
    void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree);
}

/*********************************************
 * i. Diagram - Relationship implementations
 *********************************************/

/*********************************************
 * j. Program - Binary Tree Implementation
 * The binary tree whose nodes contain a one-letter string that was used to test the four traversals.
 *********************************************/
class TestBinaryTree extends BinaryTree<String> implements BinaryTreeInterface<String> {
    @Override
    public void setTree(String rootData) {
        setRoot(new TreeNode<>(rootData));
    }

    @Override
    public void setTree(String rootData, BinaryTree<String> leftTree, BinaryTree<String> rightTree) {
        setRoot(new TreeNode<>(rootData));
        if (leftTree != null) {
            getRoot().left = leftTree.getRoot();
        }
        if (rightTree != null) {
            getRoot().right = rightTree.getRoot();
        }
    }

    @Override
    public Iterator<String> getPreorderIterator() {
        return new PreorderIterator<>(getRoot());
    }

    @Override
    public Iterator<String> getPostorderIterator() {
        return new PostorderIterator<>(getRoot());
    }

    @Override
    public Iterator<String> getLevelOrderIterator() {
        return new LevelOrderIterator<>(getRoot());
    }
}

/*********************************************
 * k. Program - Preorder Traversal
 * Program test the Preorder Traversal
 *********************************************/
class PreorderIterator<T> implements Iterator<T> {
    private Stack<TreeNode<T>> stack = new Stack<>();

    public PreorderIterator(TreeNode<T> root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        TreeNode<T> node = stack.pop();
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
        return node.value;
    }
}

/*********************************************
 * l. Program - Postorder Traversal
 * Program test the Postorder Traversal
 *********************************************/
class PostorderIterator<T> implements Iterator<T> {
    private Stack<TreeNode<T>> stack = new Stack<>();
    private Set<TreeNode<T>> visited = new HashSet<>();

    public PostorderIterator(TreeNode<T> root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        while (true) {
            TreeNode<T> current = stack.peek();

            if ((current.left == null && current.right == null) ||
                    (current.left == null || visited.contains(current.left)) &&
                            (current.right == null || visited.contains(current.right))) {
                visited.add(current);
                stack.pop();
                return current.value;
            }

            if (current.right != null && !visited.contains(current.right)) {
                stack.push(current.right);
            }
            if (current.left != null && !visited.contains(current.left)) {
                stack.push(current.left);
            }
        }
    }
}

/*********************************************
 * m. Program - Level Order Traversal
 * Program test the Level Order Traversal
 *********************************************/
class LevelOrderIterator<T> implements Iterator<T> {
    private Queue<TreeNode<T>> queue = new LinkedList<>();

    public LevelOrderIterator(TreeNode<T> root) {
        if (root != null) {
            queue.offer(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        TreeNode<T> node = queue.poll();
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
        return node.value;
    }
}

/*********************************************
 * n. Program - Inorder Traversal
 * Program test the Inorder Traversal
 *********************************************/
class InorderIterator<T> implements Iterator<T> {
    private Stack<TreeNode<T>> stack = new Stack<>();
    private TreeNode<T> current;

    public InorderIterator(TreeNode<T> root) {
        current = root;
        pushLeftNodes(current);
    }

    private void pushLeftNodes(TreeNode<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        TreeNode<T> node = stack.pop();
        pushLeftNodes(node.right);
        return node.value;
    }
}

/*********************************************
 * Main class for testing
 * o. Program doesn't present errors and warnings
 * p. Program comments included
 *********************************************/
class Main {
    public static void main(String[] args) {
        // Create test tree
        TestBinaryTree tree = new TestBinaryTree();
        tree.setRoot(new TreeNode<>("a"));
        tree.getRoot().left = new TreeNode<>("b");
        tree.getRoot().right = new TreeNode<>("c");
        tree.getRoot().left.left = new TreeNode<>("d");
        tree.getRoot().left.right = new TreeNode<>("e");
        tree.getRoot().right.right = new TreeNode<>("f");
        tree.getRoot().right.right.left = new TreeNode<>("g");

        // Test all traversals
        System.out.println("Preorder traversal:");
        Iterator<String> preorder = tree.getPreorderIterator();
        while (preorder.hasNext()) {
            System.out.print(preorder.next() + " ");
        }

        System.out.println("\n\nPostorder traversal:");
        Iterator<String> postorder = tree.getPostorderIterator();
        while (postorder.hasNext()) {
            System.out.print(postorder.next() + " ");
        }

        System.out.println("\n\nLevel-order traversal:");
        Iterator<String> levelOrder = tree.getLevelOrderIterator();
        while (levelOrder.hasNext()) {
            System.out.print(levelOrder.next() + " ");
        }

        System.out.println("\n\nInorder traversal:");
        Iterator<String> inorder = new InorderIterator<>(tree.getRoot());
        while (inorder.hasNext()) {
            System.out.print(inorder.next() + " ");
        }
    }

    // Author : Ahmet C Sekerci
}