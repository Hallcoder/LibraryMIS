package org.zesta.app.librarymis.services;

import org.zesta.app.librarymis.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    public List<Book> getBooks();
    public Book createBook(Book book);
    public Optional<Book> getBookById(int id);
    public Book updateBook(Book newBook);
}
