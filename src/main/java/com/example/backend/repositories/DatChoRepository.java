package com.example.backend.repositories;

import com.example.backend.entities.DatCho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatChoRepository extends MongoRepository<DatCho,String> {
}
