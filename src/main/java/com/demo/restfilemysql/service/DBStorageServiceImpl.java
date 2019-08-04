package com.demo.restfilemysql.service;

import com.demo.restfilemysql.exception.FileStorageException;
import com.demo.restfilemysql.exception.MyFileNotFoundException;
import com.demo.restfilemysql.model.DBFile;
import com.demo.restfilemysql.repository.DBFIleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBStorageServiceImpl implements DBStorageService {

    @Autowired
    private DBFIleRepository dbfIleRepository;

    @Override
    public DBFile storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            DBFile dbFile = new DBFile(fileName, file.getContentType(),file.getBytes());
            return dbfIleRepository.save(dbFile);
        }catch (IOException e){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
    }

    @Override
    public DBFile getFile(String fileId) {
        return dbfIleRepository.findById(fileId).orElseThrow(()-> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
