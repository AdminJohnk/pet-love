package com.example.backend.services.loaithucung;

import com.example.backend.dtos.loaithucung.LoaiThuCungDTO;
import com.example.backend.entities.LoaiThuCung;

public  interface LoaiThuCungService {

    LoaiThuCung getLoaiThuCung(String id);

    LoaiThuCung createLoaiThuCung(LoaiThuCungDTO DTO);

    LoaiThuCung updateLoaiThuCung(String id, LoaiThuCungDTO DTO);

    LoaiThuCung deleteLoaiThuCung(String id);
}
