package org.zesta.app.librarymis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zesta.app.librarymis.models.LibraryUser;

public interface ILibraryUserRepository extends JpaRepository<LibraryUser, Integer> {
}
