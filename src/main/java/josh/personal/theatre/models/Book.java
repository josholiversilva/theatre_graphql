package josh.personal.theatre.models;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(String id, String name, int pageCount, String authorId) {
    private static final List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "author-1"),
            new Book("book-2", "Down Under", 208, "author-2"),
            new Book("book-3", "Up Over", 102, "author-3")
    );

    public static Optional<Book> getById(String id) {
        return books
                .stream()
                .filter(book -> book.id().equals(id))
                .findFirst();
    }
}
