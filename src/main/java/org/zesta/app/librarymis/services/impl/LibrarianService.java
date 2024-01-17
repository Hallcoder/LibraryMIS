package org.zesta.app.librarymis.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zesta.app.librarymis.models.Librarian;
import org.zesta.app.librarymis.repositories.ILibrarianRepository;
import org.zesta.app.librarymis.services.ILibrarianService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService implements ILibrarianService {
    private final ILibrarianRepository librarianRepository;
    @Override
    public Librarian create(Librarian lib) {
        return librarianRepository.save(lib);
    }

    @Override
    public List<Librarian> getAll() {
        return librarianRepository.findAll();
    }
}
