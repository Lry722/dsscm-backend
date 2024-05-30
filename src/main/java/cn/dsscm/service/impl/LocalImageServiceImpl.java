package cn.dsscm.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.service.ImageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocalImageServiceImpl implements ImageService {
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public String upload(String part, MultipartFile file)
            throws IllegalStateException, IOException {
        String filename = UUID.randomUUID().toString() + "." + file.getOriginalFilename().split("\\.")[1];
        Path targetFile = Path.of(uploadPath, part, filename);
        Files.createDirectories(targetFile.getParent());
        file.transferTo(targetFile);
        log.info("Uploaded file: {}", targetFile.toAbsolutePath());
        return filename;
    }

    @Override
    public void delete(String part, String filename) {
        File targetFile = new File(uploadPath + "/" + part + "/" + filename);
        targetFile.delete();
    }

    @Override
    public byte[] get(String part, String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            return null;
        }
        Path targetFile = Path.of(uploadPath, part, filename);
        return Files.readAllBytes(targetFile);
    }
}
