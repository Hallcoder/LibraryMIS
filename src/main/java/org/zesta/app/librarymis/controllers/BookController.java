package org.zesta.app.librarymis.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zesta.app.librarymis.dto.CreateBookDTO;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.models.Subject;
import org.zesta.app.librarymis.payload.ApiResponse;
import org.zesta.app.librarymis.repositories.IBookRepository;
import org.zesta.app.librarymis.services.IFileService;
import org.zesta.app.librarymis.services.impl.BookService;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final IBookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final IFileService fileService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getBooks() {
        ApiResponse<List<Book>> response = new ApiResponse<List<Book>>();
        List<Book> books = bookService.getBooks();
        response.setMessage("Books here");
        response.setData(books);
        response.setStatus(200);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/testFile")
    public ResponseEntity<String> testUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.saveFile(file,"testBooks");
        return ResponseEntity.ok("File saved!");
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Book>> createBook(@ModelAttribute CreateBookDTO book) throws IOException {
        System.out.println("Creating book");
        Book newBook = new Book();
        newBook.setISBN(book.getIsbn());
        newBook.setAvailable(book.isAvailable());
        newBook.setAuthor(book.getAuthor());
        newBook.setTitle(book.getTitle());
        newBook.setQuantity(book.getQuantity());
        newBook.setLentAmount(book.getLentAmount());
        newBook.setSubject(new Subject(book.getSubject()));
        newBook = bookService.createBook(newBook, book.getFile());
        return ResponseEntity.ok(new ApiResponse<Book>("Book created successfully", 200, newBook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        Book existingBook = bookService.getBookById(id).orElseThrow(() -> new NoSuchElementException());
        modelMapper.map(book, existingBook);
        bookRepository.save(existingBook);
        return ResponseEntity.ok(new ApiResponse<Book>("Book updated successfully", 200, existingBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<Book>("Book deleted successfully", 200, null));
    }
}
