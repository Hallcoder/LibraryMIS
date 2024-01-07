package org.zesta.app.librarymis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany
    @JoinTable(
            name = "librarian_borrowed_books",
            joinColumns = @JoinColumn(name = "librarian_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @JsonIgnore
    private List<Book> currentBorrowedBooks;
    @OneToMany(mappedBy = "borrower")
    @JsonIgnore
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
