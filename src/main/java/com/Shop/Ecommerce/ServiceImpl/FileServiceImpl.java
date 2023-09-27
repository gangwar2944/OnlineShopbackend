package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.FileInfo;
import com.Shop.Ecommerce.Exceptions.FileUploadException;
import com.Shop.Ecommerce.Repository.FileInfoRepository;
import com.Shop.Ecommerce.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileInfoRepository fileInfoRepository;
    @Override
    public String uploadFile(String path,MultipartFile file) throws FileUploadException {
        try {
        if (file.isEmpty()) {
            throw new FileUploadException("Please select a file to upload.");
        }

        // Save the file to a folder (e.g., uploads) on your server

            String fileName = file.getOriginalFilename();
            String randomId = UUID.randomUUID().toString();

           String newName = randomId.concat(fileName.substring(fileName.lastIndexOf(".")));

           String filePath = path + File.separator + newName;


           File uploadPath = new File(path);

        if (!uploadPath.exists()) {
            uploadPath.mkdir();
        }

            Files.copy(file.getInputStream(), Paths.get(filePath));

        // Save the file name in the database
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileName);
        fileInfoRepository.save(fileInfo);

        return newName;
    } catch (IOException e) {
        throw new FileUploadException("Failed to upload the file.", e);
    }

    }

    @Override
    public InputStream getResources(String path, String fileName) throws FileNotFoundException {
        String fullPath = path+File.separator+fileName;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream;
    }

    public void deleteImage(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        File imageFile = new File(fullPath);

        if (imageFile.exists()) {
            if (imageFile.delete()) {
                System.out.println("Image deleted successfully.");
            } else {
                System.err.println("Failed to delete the image.");
            }
        } else {
            System.err.println("Image not found at: " + fullPath);
        }
    }
}
