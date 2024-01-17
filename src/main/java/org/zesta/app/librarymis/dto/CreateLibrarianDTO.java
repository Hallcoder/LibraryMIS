package org.zesta.app.librarymis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateLibrarianDTO {
    private String firstName;
    private String lastName;
    private LocalDateTime dob;
    private String email;
    private String password;
    private int age;

}
