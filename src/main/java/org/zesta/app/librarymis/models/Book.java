package org.zesta.app.librarymis.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String ISBN;
    private boolean available;
    private int quantity;
    private int lentAmount;
    @OneToMany(mappedBy = "borrowedBook")
    private List<LibraryTransaction> transactions;

    public boolean getAvailable(){
        return quantity > lentAmount;
    }

}
