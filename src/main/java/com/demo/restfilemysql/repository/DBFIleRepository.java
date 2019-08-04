package com.demo.restfilemysql.repository;

import com.demo.restfilemysql.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFIleRepository extends JpaRepository<DBFile,String> {
}
