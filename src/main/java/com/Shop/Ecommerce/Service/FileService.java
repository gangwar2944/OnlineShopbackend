package com.Shop.Ecommerce.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface FileService {
    String uploadFile(String path,MultipartFile file);

    InputStream getResources(String path,String fileName) throws FileNotFoundException;
}
