package org.zesta.app.librarymis.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.repositories.IBookRepository;
import org.zesta.app.librarymis.services.IBookService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    @Override
    public List<Book> getBooks() {
        return  bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(Book newBook) {
        return bookRepository.save(newBook);
    }
}
