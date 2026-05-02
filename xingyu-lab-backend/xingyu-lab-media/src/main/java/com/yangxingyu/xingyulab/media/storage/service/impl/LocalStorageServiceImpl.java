package com.yangxingyu.xingyulab.media.storage.service.impl;

import com.yangxingyu.xingyulab.media.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class LocalStorageServiceImpl implements StorageService {

    @Value("${storage.local.base-path:./uploads}")
    private String basePath;

    @Value("${storage.local.base-url:http://localhost:8080/uploads}")
    private String baseUrl;

    @Override
    public String upload(String path, InputStream inputStream) {
        try {
            Path filePath = Paths.get(basePath, path);
            Files.createDirectories(filePath.getParent());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return baseUrl + "/" + path;
        } catch (IOException e) {
            log.error("本地文件上传失败: {}", path, e);
            throw new RuntimeException("文件上传失败", e);
        }
    }

    @Override
    public void delete(String path) {
        try {
            Path filePath = Paths.get(basePath, path);
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            log.error("本地文件删除失败: {}", path, e);
        }
    }

    @Override
    public String getStorageType() {
        return "local";
    }
}
