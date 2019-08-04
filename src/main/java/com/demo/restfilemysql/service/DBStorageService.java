package com.demo.restfilemysql.service;

import com.demo.restfilemysql.model.DBFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface DBStorageService {

    DBFile storeFile(MultipartFile file);
    DBFile getFile(String fileId);
}
