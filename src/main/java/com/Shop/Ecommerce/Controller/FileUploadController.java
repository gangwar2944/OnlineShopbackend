package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.Exceptions.FileUploadException;
import com.Shop.Ecommerce.Repository.FileInfoRepository;
import com.Shop.Ecommerce.Service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file){
       try{
           return fileService.uploadFile(path,file);
       }catch (FileUploadException e){
           return "file upload failed " + e.getMessage();
       }
    }
    @GetMapping("/getImage/{imageName}")
    public void serveImage(@PathVariable("imageName") String fileName , HttpServletResponse response) throws IOException {
       InputStream resources = fileService.getResources(path,fileName);
       response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resources,response.getOutputStream());
    }
}
