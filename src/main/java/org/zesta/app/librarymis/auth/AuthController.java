package org.zesta.app.librarymis.auth;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zesta.app.librarymis.models.LibraryUser;
import org.zesta.app.librarymis.models.User;
import org.zesta.app.librarymis.repositories.ILibraryUserRepository;

@Controller
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final ModelMapper modelMapper;
    private final ILibraryUserRepository libraryUserRepository;

    @PostMapping("/libraryUser/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody LibraryUser req){
        LibraryUser newUser  = new LibraryUser();
        modelMapper.map(req,newUser);
        User newUser = new User(req.getEmail(),req.password());
        newUser = libraryUserRepository.save(newUser);
        return ResponseEntity.ok(new AuthenticationResponse(null,newUser));
    }

    @PostMapping("/login")
    public
}
