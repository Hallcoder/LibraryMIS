package org.zesta.app.librarymis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zesta.app.librarymis.models.LibraryTransaction;

public interface ITransactionRepository extends JpaRepository<LibraryTransaction,Integer> {
}
