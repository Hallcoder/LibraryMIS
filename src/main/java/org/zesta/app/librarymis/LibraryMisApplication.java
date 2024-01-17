package org.zesta.app.librarymis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalAuthentication(prePostEnabled = true)
public class LibraryMisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryMisApplication.class, args);
    }
}
