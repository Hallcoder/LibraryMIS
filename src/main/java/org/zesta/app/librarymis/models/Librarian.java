package org.zesta.app.librarymis.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zesta.app.librarymis.Utils.Person;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Librarian extends Person {
    @Id
    @GeneratedValue
    private int id;
    private Date startingWorkDate;
    private int workingHours;
    @OneToOne()
    private User profile;
    private double salaryInDollars;
    public Librarian(String email, String firstName, String lastName, int age) {
        super(email, firstName, lastName, age);
    }
}
