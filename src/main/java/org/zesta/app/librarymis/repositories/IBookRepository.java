package org.zesta.app.librarymis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zesta.app.librarymis.models.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
