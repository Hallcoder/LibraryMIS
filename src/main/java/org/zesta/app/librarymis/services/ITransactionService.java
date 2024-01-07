package org.zesta.app.librarymis.services;

import org.apache.tomcat.jni.Library;
import org.zesta.app.librarymis.dto.BorrowBookDTO;
import org.zesta.app.librarymis.models.LibraryTransaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionService {
    LibraryTransaction create(BorrowBookDTO dto) throws Exception;
    List<LibraryTransaction> getTransactions();
    Optional<LibraryTransaction> getTransactionById(int id);
    LibraryTransaction updateTransaction(int id,LibraryTransaction newTransaction);

    void issueReturn(BorrowBookDTO req);
}
