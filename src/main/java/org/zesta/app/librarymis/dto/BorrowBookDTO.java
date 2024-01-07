package org.zesta.app.librarymis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BorrowBookDTO {
    private int bookId;
    private int userId;
}
