package josh.personal.theatre.cache;

import josh.personal.theatre.models.Movie;

public class Node<T> {
    public T data;
    public Node<T> prev;
    public Node<T> nxt;

    public Node(T data, Node<T> prev, Node<T> nxt) {
        this.data = data;
        this.prev = prev;
        this.nxt = nxt;
    }

    public Node(T data) {
        this(data, null, null);
    }
}
