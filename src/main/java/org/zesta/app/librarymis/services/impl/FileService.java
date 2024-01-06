package org.zesta.app.librarymis.services.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zesta.app.librarymis.services.IFileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileService implements IFileService {
    @Value("${file.upload.dir}")
    private String rootDir;
    @Override
    public String saveFile(MultipartFile file, String documentType) throws IOException {
        String savePath = rootDir + "/" + documentType.toLowerCase();
        String fileName = file.getOriginalFilename() + UUID.randomUUID().toString();
        Path filePath = Paths.get(savePath + "/" + fileName);

        if (!Files.exists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return "File saved to " + filePath;
    }
}
