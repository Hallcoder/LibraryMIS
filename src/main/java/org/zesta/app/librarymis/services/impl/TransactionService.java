package org.zesta.app.librarymis.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zesta.app.librarymis.dto.BorrowBookDTO;
import org.zesta.app.librarymis.models.Book;
import org.zesta.app.librarymis.models.LibraryTransaction;
import org.zesta.app.librarymis.models.LibraryUser;
import org.zesta.app.librarymis.models.User;
import org.zesta.app.librarymis.repositories.IBookRepository;
import org.zesta.app.librarymis.repositories.ILibraryUserRepository;
import org.zesta.app.librarymis.repositories.ITransactionRepository;
import org.zesta.app.librarymis.repositories.IUserRepository;
import org.zesta.app.librarymis.services.ITransactionService;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {
    private final ITransactionRepository transactionRepository;
    private final IBookRepository bookRepository;
    private final IUserRepository userRepository;
    private final ILibraryUserRepository libraryUserRepository;
    @Override
    public LibraryTransaction create(BorrowBookDTO dto) throws Exception {
       Optional<Book> book =  bookRepository.findById(dto.getBookId());
       if(book.get().getAvailable()){
           book.get().setLentAmount(book.get().getLentAmount()+1);
           bookRepository.save(book.get());
           System.out.println("dto userid " + dto.getUserId());
           Optional<LibraryUser> user =  libraryUserRepository.findById(dto.getUserId());
           System.out.println("Book title" + book.get().getTitle());
           System.out.println("User email" + user.get().getEmail());
           LibraryTransaction transaction = new LibraryTransaction();
           transaction.setBorrower(user.get());
           transaction.setBorrowedBook(book.get());
           transaction.setBorrowDate();
           transaction.setReturnDate();
           user.get().setCurrentBorrowedBooks(user.get().getCurrentBorrowedBooks().add(book.get()));
           transaction = transactionRepository.save(transaction);
           return transaction;
       }
        throw new Exception("Book Not available");
    }



    @Override
    public List<LibraryTransaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<LibraryTransaction> getTransactionById(int id) {
        return Optional.empty();
    }

    @Override
    public LibraryTransaction updateTransaction(int id, LibraryTransaction newTransaction) {
        return null;
    }

    @Override
    public void issueReturn(BorrowBookDTO req) {
        Optional<Book> book = bookRepository.findById(req.getBookId());
        Optional<LibraryUser> user = libraryUserRepository.findById(req.getUserId());
        book.get().setLentAmount(book.get().getLentAmount()+1);
        user.get().getCurrentBorrowedBooks().remove(book);
        bookRepository.save(book.get());
        libraryUserRepository.save(user.get());
    }
}
