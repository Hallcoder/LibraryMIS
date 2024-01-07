package org.zesta.app.librarymis.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zesta.app.librarymis.payload.ApiResponse;
import org.zesta.app.librarymis.services.ILibraryUserService;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/libraryuser")
public class LibraryUserController {
    private final ILibraryUserService libraryUserService;
    @GetMapping
    public ResponseEntity<ApiResponse> getLibraryUsers(){
        return ResponseEntity.ok(new ApiResponse<>("Here library users are",200,libraryUserService.getUsers()));
    }
}
