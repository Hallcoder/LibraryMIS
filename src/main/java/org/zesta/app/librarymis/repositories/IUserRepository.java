package org.zesta.app.librarymis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zesta.app.librarymis.models.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}
