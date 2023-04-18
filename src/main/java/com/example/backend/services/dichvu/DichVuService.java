package com.example.backend.services.dichvu;

import com.example.backend.dtos.dichvu.DichVuDTO;
import com.example.backend.entities.DichVu;

public interface DichVuService {
    DichVu getDichVu(String id);
    DichVu create(DichVuDTO DTO);
    DichVu update(String id, DichVuDTO DTO);
    DichVu delete(String id);
}
