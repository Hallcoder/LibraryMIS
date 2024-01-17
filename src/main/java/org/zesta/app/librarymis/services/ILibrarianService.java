package org.zesta.app.librarymis.services;

import org.zesta.app.librarymis.dto.CreateLibrarianDTO;
import org.zesta.app.librarymis.models.Librarian;

import java.util.List;
import java.util.Optional;

public interface ILibrarianService {
    Librarian create(Librarian lib);
    List<Librarian> getAll();
}
