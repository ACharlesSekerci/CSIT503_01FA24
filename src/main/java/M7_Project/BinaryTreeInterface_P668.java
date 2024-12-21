package M7_Project;

/* /

Page 668, Projects 1

classDiagram
class BinaryTreeInterface~T~ {
        <<interface>>
        +setTree(T rootData)
        +setTree(T rootData, BinaryTreeInterface~T~ leftTree, BinaryTreeInterface~T~ rightTree)
        }

class GuessingGame {
        -currentNode: GuessingNode
        +play()
        -askQuestion(String question): boolean
        -processAnswer()
        -addNewQuestion()
}

class GuessingNode {
        -data: String
        -isQuestion: boolean
        +GuessingNode(String data, boolean isQuestion)
        +getData(): String
        +isQuestion(): boolean
        +setData(String data)
        +setIsQuestion(boolean isQuestion)
}

    GuessingGame ..|> BinaryTreeInterface : implements
            GuessingGame o-- GuessingNode : contains

 */

/*
=========================================
SECTION A: Diagram - GuessGame (5 pts)
- Class diagram implementing BinaryTreeInterface
=========================================
*/

public interface BinaryTreeInterface_P668<T> {
    void setTree(T rootData);
    void setTree(T rootData, BinaryTreeInterface_P668<T> leftTree, BinaryTreeInterface_P668<T> rightTree);
}

/*
=========================================
SECTION B-I: Supporting Diagrams (40 pts total)
B: BinaryTree<T>
C: TreeInterface<T>
D: BinaryNode<T>
E: TreeIteratorInterface<T>
F: DecisionTree<T>
G: DecisionTreeInterface<T>
H: BinaryTreeIteratorInterface<T>
I: Relationship
=========================================
*/

class GuessingNode {
    private String data;
    private boolean isQuestion;

    public GuessingNode(String data, boolean isQuestion) {
        this.data = data;
        this.isQuestion = isQuestion;
    }

    public String getData() {
        return data;
    }

    public boolean isQuestion() {
        return isQuestion;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIsQuestion(boolean isQuestion) {
        this.isQuestion = isQuestion;
    }
}

/*
=========================================
SECTION J-N: Programs (40 pts total)
J: Binary Tree implementation
K: Preorder Traversal (10 pts)
L: Postorder Traversal (10 pts)
M: Level Order Traversal (10 pts)
N: Inorder Traversal (10 pts)
=========================================
*/

class GuessingGame implements BinaryTreeInterface_P668<String> {
    private GuessingNode currentNode;

    @Override
    public void setTree(String rootData) {
        currentNode = new GuessingNode(rootData, true);
    }

    @Override
    public void setTree(String rootData, BinaryTreeInterface_P668<String> leftTree,
                        BinaryTreeInterface_P668<String> rightTree) {
        currentNode = new GuessingNode(rootData, true);
        // Implementation for setting left and right trees would go here
    }

    public void play() {
        // Game logic implementation
    }

    private boolean askQuestion(String question) {
        return false; // Placeholder
    }

    private void processAnswer() {
        // Answer processing implementation
    }

    private void addNewQuestion() {
        // New question implementation
    }
}

/*
=========================================
SECTION O: Program Error Checking (5 pts)
- Program is free of errors and warnings
=========================================
*/

/*
=========================================
SECTION P: Program Comments (5 pts)
Author: Ahmet C Sekerci
=========================================
*/