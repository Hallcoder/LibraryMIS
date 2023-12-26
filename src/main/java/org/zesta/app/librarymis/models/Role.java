package org.zesta.app.librarymis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zesta.app.librarymis.Utils.enums.ERole;

import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private ERole name;
    private String description;


}
