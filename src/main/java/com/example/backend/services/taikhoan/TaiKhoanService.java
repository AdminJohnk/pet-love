package com.example.backend.services.taikhoan;

import com.example.backend.dtos.taikhoan.TaiKhoanDTO;
import com.example.backend.entities.TaiKhoan;

public interface TaiKhoanService {
    TaiKhoan getTaiKhoan(String id);
    TaiKhoan create(TaiKhoanDTO DTO);
    TaiKhoan update(String id,TaiKhoanDTO DTO);
    TaiKhoan delete(String id);
}
