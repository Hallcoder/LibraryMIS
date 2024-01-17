package org.zesta.app.librarymis.auth;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zesta.app.librarymis.Utils.enums.Role;
import org.zesta.app.librarymis.config.JwtService;
import org.zesta.app.librarymis.models.Librarian;
import org.zesta.app.librarymis.models.LibraryUser;
import org.zesta.app.librarymis.models.User;
import org.zesta.app.librarymis.repositories.ILibraryUserRepository;
import org.zesta.app.librarymis.repositories.IUserRepository;
import org.zesta.app.librarymis.security.UserPrincipal;
import org.zesta.app.librarymis.services.ILibrarianService;
import org.zesta.app.librarymis.services.ILibraryUserService;

import javax.naming.AuthenticationException;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final ModelMapper modelMapper;
    private final ILibraryUserRepository libraryUserRepository;
    private final ILibrarianService librarianService;
    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/libraryUser/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest req){
        LibraryUser newUser  = new LibraryUser();
        modelMapper.map(req,newUser);
        System.out.println(newUser);
        User user = new User(req.getEmail(),passwordEncoder.encode(req.getPassword()));
        user.setRoles(Collections.singleton(Role.LIBRARY_USER));
        userRepository.save(user);
        newUser.setProfile(user);
        newUser = libraryUserRepository.save(newUser);
        return ResponseEntity.ok(new AuthenticationResponse(null,newUser));
    }

    @PostMapping("/librarian/register")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegistrationRequest req){
        Librarian newUser  = new Librarian();
        modelMapper.map(req,newUser);
        User user = new User(req.getEmail(),passwordEncoder.encode(req.getPassword()));
        user.setRoles(Collections.singleton(Role.LIBRARIAN));
        userRepository.save(user);
        newUser.setProfile(user);
        System.out.println("Profile" + newUser.getProfile().getRoles());
        newUser = librarianService.create(newUser);
        return ResponseEntity.ok(new AuthenticationResponse(null,newUser));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequestDAO req){
        System.out.println("starting.... Email: " + req.getEmail() + " pass: " + req.getPassword());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        System.out.println("done authenticating...");
        User user = userRepository.findByEmail(req.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(UserPrincipal.create(user));
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken, user));
    }
}
