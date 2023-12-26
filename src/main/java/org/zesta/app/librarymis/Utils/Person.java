package org.zesta.app.librarymis.Utils;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zesta.app.librarymis.models.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Person {
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;
    private int age;

    public Person(String email, String firstName, String lastName, int age) {
        this.email = email;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.fullName = firstName  + lastName;
        this.age = age;
    }
}
