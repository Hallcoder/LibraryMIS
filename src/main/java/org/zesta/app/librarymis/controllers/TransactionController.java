package org.zesta.app.librarymis.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zesta.app.librarymis.dto.BorrowBookDTO;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.models.LibraryTransaction;
import org.zesta.app.librarymis.models.User;
import org.zesta.app.librarymis.payload.ApiResponse;
import org.zesta.app.librarymis.repositories.IBookRepository;
import org.zesta.app.librarymis.repositories.IUserRepository;
import org.zesta.app.librarymis.services.ITransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final ITransactionService transactionService;

    // we have lendBook, issueReturn, get info
    @PostMapping("/lendBook")
    public ResponseEntity<ApiResponse> lendBook(@RequestBody BorrowBookDTO req) throws Exception {
        LibraryTransaction transaction = transactionService.create(req);
        return ResponseEntity.ok(new ApiResponse("Lent boook", 201, transaction));
    }

    @PostMapping("/issueReturn")
    public ResponseEntity<ApiResponse> issueReturn(@RequestBody BorrowBookDTO req){
        transactionService.issueReturn(req);
        return ResponseEntity.ok(new ApiResponse("Book Returned",200,null));
    }
    @GetMapping
    public ResponseEntity<ApiResponse> getTransactions() {
        List<LibraryTransaction> transactions = transactionService.getTransactions();
        return ResponseEntity.ok(new ApiResponse("here you go!", 200, transactions));
    }
}
