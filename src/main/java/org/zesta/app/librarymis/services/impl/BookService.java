package org.zesta.app.librarymis.services.impl;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zesta.app.librarymis.dto.CreateBookDTO;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.models.Subject;
import org.zesta.app.librarymis.repositories.IBookRepository;
import org.zesta.app.librarymis.services.IBookService;
import org.zesta.app.librarymis.services.IFileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    private final IFileService fileService;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book, MultipartFile file) throws IOException {
            fileService.saveFile(file, "book/" + book.getSubject().getName());
            book.setFilePath();
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
