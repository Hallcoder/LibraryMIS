package org.zesta.app.librarymis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zesta.app.librarymis.models.Librarian;

public interface ILibrarianRepository extends JpaRepository<Librarian, Integer> {
}
