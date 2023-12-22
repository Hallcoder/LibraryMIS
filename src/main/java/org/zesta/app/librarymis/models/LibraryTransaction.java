package org.zesta.app.librarymis.models;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

@Entity
public class LibraryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private User borrower;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book borrowedBook;
    private Date borrowDate;
    private Date returnDate;

}
