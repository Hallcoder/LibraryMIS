package org.zesta.app.librarymis.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {
    public String saveFile(MultipartFile file,String documentType) throws IOException;
}
