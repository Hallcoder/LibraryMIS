package org.zesta.app.librarymis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zesta.app.librarymis.models.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
}
