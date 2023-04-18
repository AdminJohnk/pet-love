package com.example.backend.repositories;

import com.example.backend.entities.DichVu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends MongoRepository<DichVu,String> {
    @Query(value = "{'maDichVu':  ?0}", exists = true)
    boolean kiemTraMaDichVu(String maDichVu);
}
