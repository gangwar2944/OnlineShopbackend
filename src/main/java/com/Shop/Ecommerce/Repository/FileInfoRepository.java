package com.Shop.Ecommerce.Repository;
import com.Shop.Ecommerce.Entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
}

