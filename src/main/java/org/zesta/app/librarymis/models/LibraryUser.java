package org.zesta.app.librarymis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zesta.app.librarymis.Utils.Person;
import org.zesta.app.librarymis.models.Book;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LibraryUser extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int grade;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Book> currentBorrowedBooks = new ArrayList<Book>();
    @OneToMany(mappedBy = "borrower",fetch = FetchType.EAGER)
    private List<LibraryTransaction> transactions = new ArrayList<LibraryTransaction>();
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
