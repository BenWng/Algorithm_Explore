package CS5800.hw8_2_mine;

/**
 * Created by Ben_Big on 3/12/16.
 */
public interface Node{
    int getValue();
    Node getLeft();
    Node getRight();
    Node getParent();
    void changeValue(int x);
    void removeLeft();
    void removeRight();
    void addLeft(Node n);
    void addRight(Node n);
    void removeFromParent();

    public interface Traverser{
        void Traverse(Node x);
    }
}