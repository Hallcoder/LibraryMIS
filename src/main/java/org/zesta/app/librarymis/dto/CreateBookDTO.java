package org.zesta.app.librarymis.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Getter
@Setter
public class CreateBookDTO {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    private int quantity;
    private MultipartFile file;
    private String subject;
    private int lentAmount;
}

