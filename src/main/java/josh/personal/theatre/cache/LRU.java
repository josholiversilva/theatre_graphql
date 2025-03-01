package josh.personal.theatre.cache;

import josh.personal.theatre.configuration.Configuration;
import josh.personal.theatre.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component
public class LRU {
    public final int size;
    private final HashMap<String, Node<Movie>> map = new HashMap<>();
    private Node<Movie> head;
    private josh.personal.theatre.cache.Node<Movie> tail;

    @Autowired
    public LRU(Configuration config) {
        this.size = config.getLRU().getSize();
    }

    public void add(Movie movie) {
        final Node<Movie> newNode = new Node<>(movie);

        if (map.containsKey(movie.id())) {
            final Node<Movie> currNode = map.get(movie.id());
            currNode.data = movie;

            removeNode(currNode);
            addNodeAtHead(currNode);
        } else {
            if (map.size() >= size) {
                map.remove(movie.id());
                removeNode(tail);
            }

            addNodeAtHead(newNode);
        }

        map.put(movie.id(), newNode);
    }

    public Optional<Movie> get(String movieId) {
        final Node<Movie> node = map.get(movieId);
        if (node == null) {
            return Optional.empty();
        }

        removeNode(node);
        addNodeAtHead(node);

        return Optional.of(node.data);
    }

    private void removeNode(Node<Movie> node) {
        if (node.prev != null) {
            node.prev.nxt = node.nxt;
        } else {
            head = node.nxt;
        }

        if (node.nxt != null) {
            node.nxt.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addNodeAtHead(Node<Movie> node) {
        node.nxt = head;
        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }
}
