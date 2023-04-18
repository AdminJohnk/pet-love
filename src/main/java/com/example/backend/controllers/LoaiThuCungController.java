package com.example.backend.controllers;


import com.example.backend.dtos.loaithucung.LoaiThuCungDTO;
import com.example.backend.entities.LoaiThuCung;
import com.example.backend.services.loaithucung.LoaiThuCungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/loaithucung")
public class LoaiThuCungController {

    private final LoaiThuCungService loaiThuCungService;

    public LoaiThuCungController(LoaiThuCungService loaiThuCungService) {
        this.loaiThuCungService = loaiThuCungService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiThuCung> getLoaiThuCung(@PathVariable String id) { return new ResponseEntity<>(loaiThuCungService.getLoaiThuCung(id),HttpStatus.OK);}

    @PostMapping
    public ResponseEntity<LoaiThuCung> create(@RequestBody LoaiThuCungDTO DTO){
        return new ResponseEntity<>(loaiThuCungService.createLoaiThuCung(DTO),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiThuCung> update (@PathVariable String id, @RequestBody LoaiThuCungDTO DTO){
        return new ResponseEntity<>(loaiThuCungService.updateLoaiThuCung(id,DTO),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<LoaiThuCung> delete(@PathVariable String id){
        return new ResponseEntity<>(loaiThuCungService.deleteLoaiThuCung(id),HttpStatus.OK);
    }

}
