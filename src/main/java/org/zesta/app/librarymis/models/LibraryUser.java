package org.zesta.app.librarymis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zesta.app.librarymis.Utils.Person;
import org.zesta.app.librarymis.models.Book;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LibraryUser extends Person {
    @Id
    @GeneratedValue
    private Integer id;
    private int grade;

    @OneToMany(mappedBy = "borrower")
    private List<LibraryTransaction> transactions;
    @OneToOne
    private User profile;
    public LibraryUser(String email, String firstName, String lastName, int age) {
        super(email, firstName, lastName, age);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
