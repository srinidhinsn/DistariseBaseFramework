package com.distarise.base.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService extends AbstractBaseService {
    String storeFile(MultipartFile file);
    Resource loadFileAsResource(String fileName);
}
