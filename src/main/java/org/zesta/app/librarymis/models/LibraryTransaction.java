package org.zesta.app.librarymis.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class LibraryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private LibraryUser borrower;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book borrowedBook;
    private Date borrowDate;
    private Date returnDate;

}
