package org.zesta.app.librarymis.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zesta.app.librarymis.BookDao;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.payload.ApiResponse;
import org.zesta.app.librarymis.services.impl.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
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
        Book newBook = bookService.createBook(book);
        return ResponseEntity.ok(new ApiResponse<Book>("Book created successfully",200,newBook));
    }
}
