package josh.personal.theatre.controllers;

import josh.personal.theatre.models.Author;
import josh.personal.theatre.models.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookController {
    @QueryMapping
    public Optional<Book> bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        return Author.getById(book.authorId());
    }
}
