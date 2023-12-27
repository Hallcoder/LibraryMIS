package org.zesta.app.librarymis.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zesta.app.librarymis.models.User;
import org.zesta.app.librarymis.repositories.IUserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        System.out.println("User" + user.getPassword());
        return UserPrincipal.create(user);
    }
}
