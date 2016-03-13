package CS5800.hw8_2_mine;

/**
 * Created by Ben_Big on 3/12/16.
 */
public interface Node<E>{
    void removeLeft();
    void removeRight();
    void addLeft(Node<E> n);
    void addRight(Node<E> n);
    void removeFromParent();

    interface Traverser<E>{
        void Traverse();
    }
}