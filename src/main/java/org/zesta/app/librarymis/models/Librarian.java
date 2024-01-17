package org.zesta.app.librarymis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zesta.app.librarymis.Utils.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Librarian extends Person {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne()
    private User profile;
    public Librarian(String email, String firstName, String lastName, int age) {
        super(email, firstName, lastName, age);
    }

    public void setFullName(){
        this.setFullName(this.getFirstName()+this.getLastName());
    }
}
