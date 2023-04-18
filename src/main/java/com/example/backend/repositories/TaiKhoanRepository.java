package com.example.backend.repositories;

import com.example.backend.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends MongoRepository<TaiKhoan,String> {

    @Query(value = "{'email': ?0}", exists = true)
    boolean kiemtraEmail(String email);
}
