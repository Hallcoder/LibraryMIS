package org.zesta.app.librarymis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    private String downloadUrl;
    private String title;
    private String author;
    private String ISBN;
    private boolean available;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    private Subject subject;
    private int lentAmount;
    @OneToMany(mappedBy = "borrowedBook")
    @JsonIgnore
    private List<LibraryTransaction> transactions;

    public boolean getAvailable(){
        return quantity > lentAmount;
    }

}
