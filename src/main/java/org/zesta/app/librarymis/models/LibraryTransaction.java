package org.zesta.app.librarymis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private LibraryUser borrower;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book borrowedBook;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public void setBorrowDate() {
        this.borrowDate = LocalDate.now();
    }
    public void setReturnDate(){
        this.returnDate = this.borrowDate.plus(7, ChronoUnit.DAYS);
    }
}
