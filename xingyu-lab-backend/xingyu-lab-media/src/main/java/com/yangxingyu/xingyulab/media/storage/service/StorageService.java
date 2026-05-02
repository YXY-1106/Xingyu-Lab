package com.yangxingyu.xingyulab.media.storage.service;

import java.io.InputStream;

public interface StorageService {
    String upload(String path, InputStream inputStream);
    void delete(String path);
    String getStorageType();
}
