package com.example.backend.controllers;

import com.example.backend.dtos.taikhoan.TaiKhoanDTO;
import com.example.backend.entities.TaiKhoan;
import com.example.backend.services.taikhoan.TaiKhoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;

    public TaiKhoanController(TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoan(@PathVariable String id) {
        return new ResponseEntity<>(taiKhoanService.getTaiKhoan(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaiKhoan> create(@RequestBody TaiKhoanDTO DTO) {
        return new ResponseEntity<>(taiKhoanService.create(DTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaiKhoan> update(@PathVariable String id, @RequestBody TaiKhoanDTO DTO) {
        return new ResponseEntity<>(taiKhoanService.update(id, DTO), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaiKhoan> delete(@PathVariable String id) {
        return new ResponseEntity<>(taiKhoanService.delete(id), HttpStatus.OK);
    }
}

