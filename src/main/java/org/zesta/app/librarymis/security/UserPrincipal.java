package org.zesta.app.librarymis.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zesta.app.librarymis.models.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPrincipal implements UserDetails {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;
    private String password;
    private int age;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer id, String email, String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
//        System.out.println("During construction:" +password);
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetails create(User user) {
//        System.out.println("User password: " +  user.getPassword());
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
        var userPrincipal =  new UserPrincipal(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
        System.out.println(userPrincipal);
        return userPrincipal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
