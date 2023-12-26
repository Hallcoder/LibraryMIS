package org.zesta.app.librarymis.services;

import org.zesta.app.librarymis.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public User create(User user);
    public User update(User user);
    public boolean delete(User user);
    public List<User> getAll();
    public Optional<User> findById(int id);
}
