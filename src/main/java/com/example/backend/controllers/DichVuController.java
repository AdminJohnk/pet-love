package com.example.backend.controllers;

import com.example.backend.dtos.dichvu.DichVuDTO;
import com.example.backend.entities.DichVu;
import com.example.backend.services.dichvu.DichVuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/dichvu")
public class DichVuController {
    private final DichVuService dichVuService;

    public DichVuController(DichVuService dichVuService) {
        this.dichVuService = dichVuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DichVu> getDichVu(@PathVariable String id){
        return new ResponseEntity<>(dichVuService.getDichVu(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DichVu> create(@RequestBody DichVuDTO DTO){
        return new ResponseEntity<>(dichVuService.create(DTO),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DichVu> update(@PathVariable String id, @RequestBody DichVuDTO DTO){
        return new ResponseEntity<>(dichVuService.update(id, DTO),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DichVu> delete(@PathVariable String id){
        return new ResponseEntity<>(dichVuService.delete(id),HttpStatus.OK);
    }
}
