package org.zesta.app.librarymis.services;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
 String uploadFile(MultipartFile file, String folderName);
}
