package org.zesta.app.librarymis.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequestDAO {
    private String email;
    private String password;
}
