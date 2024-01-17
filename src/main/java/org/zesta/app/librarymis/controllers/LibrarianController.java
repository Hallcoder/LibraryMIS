package org.zesta.app.librarymis.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zesta.app.librarymis.dto.CreateLibrarianDTO;
import org.zesta.app.librarymis.models.Librarian;
import org.zesta.app.librarymis.models.User;
import org.zesta.app.librarymis.payload.ApiResponse;
import org.zesta.app.librarymis.services.ILibrarianService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final ILibrarianService librarianService;
    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        List<Librarian> librarianList  = librarianService.getAll();
        return ResponseEntity.ok(new ApiResponse("Here",200,librarianList));
    }
}
