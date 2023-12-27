package org.zesta.app.librarymis.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zesta.app.librarymis.BookDao;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.payload.ApiResponse;
import org.zesta.app.librarymis.repositories.IBookRepository;
import org.zesta.app.librarymis.services.impl.BookService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final IBookRepository bookRepository;
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getBooks(){
        ApiResponse<List<Book>> response  = new ApiResponse<List<Book>>();
        List<Book> books = bookService.getBooks();
        response.setMessage("Books here");
        response.setData(books);
        response.setStatus(200);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> createBook(@RequestBody Book book){
        System.out.println("Creating book");
        Book newBook = bookService.createBook(book);
        return ResponseEntity.ok(new ApiResponse<Book>("Book created successfully",200,newBook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@RequestBody Book book,@PathVariable("id") int id){
        Book existingBook = bookService.getBookById(id).orElseThrow(() -> new NoSuchElementException());
        modelMapper.map(book,existingBook);
        bookRepository.save(existingBook);
        return ResponseEntity.ok(new ApiResponse<Book>("Book updated successfully",200,existingBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable("id") int id){
        bookRepository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<Book>("Book deleted successfully",200,null));
    }
}
