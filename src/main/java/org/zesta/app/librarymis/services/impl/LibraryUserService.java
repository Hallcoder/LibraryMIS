package org.zesta.app.librarymis.services.impl;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zesta.app.librarymis.models.LibraryTransaction;
import org.zesta.app.librarymis.models.LibraryUser;
import org.zesta.app.librarymis.repositories.ILibraryUserRepository;
import org.zesta.app.librarymis.services.ILibraryUserService;

import java.lang.reflect.Array;
import java.util.List;

@Service
@AllArgsConstructor
public class LibraryUserService implements ILibraryUserService {
    private final ILibraryUserRepository libraryUserRepository;
    @Override
    public List<LibraryUser> getUsers() {
        List<LibraryUser> users =  libraryUserRepository.findAll();
        Object[] us = users.toArray();
//        System.out.println("Yuhuuuuuu" + us[0]);
        return users;
    }
}
