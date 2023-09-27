package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.Entity.Category;
import com.Shop.Ecommerce.Entity.Product;
import com.Shop.Ecommerce.Exceptions.FileUploadException;
import com.Shop.Ecommerce.Repository.CategoryRepo;
import com.Shop.Ecommerce.Repository.FileInfoRepository;
import com.Shop.Ecommerce.Repository.ProductRepo;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.FileService;
import com.Shop.Ecommerce.Service.ProductService;
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
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;

    @PostMapping("/upload/{productId}")
    public String uploadFile(@RequestParam("file") MultipartFile file ,@PathVariable Long productId) {
        Optional<Product> byIdProduct = productRepo.findById(productId);
        if (byIdProduct.isPresent()) {
            try {
                String name = fileService.uploadFile(path, file);
                Product product = byIdProduct.get();
                product.setImage(name);
                productRepo.saveAndFlush(product);
                return name;
            } catch (FileUploadException e) {
                return "file upload failed " + e.getMessage();
            }
        }else{
           return "Product not found with this id";
        }
    }
    @PostMapping("/uploadCategoryImage/{categoryId}")
    public String uploadCategoryImage(@RequestParam("file") MultipartFile file ,@PathVariable Long categoryId) {
        Optional<Category> byIdCategory = categoryRepo.findById(categoryId);
        if (byIdCategory.isPresent()) {
            try {
                String name = fileService.uploadFile(path, file);
                Category category = byIdCategory.get();
                category.setImg(name);
                categoryRepo.saveAndFlush(category);
                return name;
            } catch (FileUploadException e) {
                return "file upload failed " + e.getMessage();
            }
        }else{
            return "Product not found with this id";
        }
    }

    @GetMapping("/getImage/{imageName}")
    public void serveImage(@PathVariable("imageName") String fileName , HttpServletResponse response) throws IOException {
       InputStream resources = fileService.getResources(path,fileName);
       response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resources,response.getOutputStream());
    }
}
