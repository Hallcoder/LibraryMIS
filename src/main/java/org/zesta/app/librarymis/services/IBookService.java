package org.zesta.app.librarymis.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.repositories.IBookRepository;

import java.util.ArrayList;
import java.util.List;

public interface IBookService {
    public List<Book> getBooks();
    public Book createBook(Book book);
}
