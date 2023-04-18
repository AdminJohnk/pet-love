package com.example.backend.dtos.dichvu;

import com.example.backend.entities.embedded.GiaDichVu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DichVuDTO {
    private String maDichVu;
    private String tenDichVu;
    private String noiDung;
    private List<GiaDichVu> giaDichVus = new ArrayList<>();
}
