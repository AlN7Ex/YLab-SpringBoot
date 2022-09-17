package com.edu.ulab.app.dao;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.storage.Storage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao {

    private static Long BOOKS_COUNT = 0L;

    private final Storage storage;

    public BookDao(Storage storage) {
        this.storage = storage;
    }

    public List<BookDto> getAllBooks() {
        return storage.getAllBooks();
    }

    public BookDto addBook(BookDto book) {
        if (BOOKS_COUNT < 0) {
            return null;
        }
        book.setId(++BOOKS_COUNT);
        return storage.addBook(book);
    }
}
