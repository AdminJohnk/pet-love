package com.example.backend.services.datcho;

import com.example.backend.dtos.datcho.DatChoDTO;
import com.example.backend.entities.DatCho;

public interface DatChoService {
    DatCho getDatCho(String id);
    DatCho create(DatChoDTO DTO);
    DatCho update(String id, DatChoDTO DTO);
    DatCho delete(String id);
}
