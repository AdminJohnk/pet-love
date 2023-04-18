package com.example.backend.services.dichvu;

import com.example.backend.dtos.dichvu.DichVuDTO;
import com.example.backend.entities.DichVu;
import com.example.backend.exceptions.InvalidException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.repositories.DichVuRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DichVuServiceImpl implements DichVuService{

    private final DichVuRepository dichVuRepository;

    public DichVuServiceImpl(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }

    @Override
    public DichVu getDichVu(String id) {
        return dichVuRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Không tồn tại dịch vụ có mã id là: %s",id)));
    }

    @Override
    public DichVu create(DichVuDTO DTO) {
        if (ObjectUtils.isEmpty(DTO.getMaDichVu())){
            throw new InvalidException("Mã dịch vụ không được để trống");
        }
        if (ObjectUtils.isEmpty(DTO.getTenDichVu())){
            throw new InvalidException("Tên dịch vụ không được để trống");

        }
        if (ObjectUtils.isEmpty(DTO.getNoiDung())){
            throw new InvalidException("Nội dung không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getGiaDichVus())){
            throw new InvalidException("Giá dịch vụ không được để trống");

        }
        if(dichVuRepository.kiemTraMaDichVu(DTO.getMaDichVu())){
            throw new InvalidException(String.format("Dịch vụ có mã %s đã tồn tại",DTO.getMaDichVu()));
        }
        DichVu dichVu = new DichVu();
        dichVu.setMaDichVu(DTO.getMaDichVu().trim());
        dichVu.setTenDichVu(DTO.getTenDichVu().trim());
        dichVu.setNoiDung(DTO.getNoiDung());
        dichVu.setGiaDichVus(DTO.getGiaDichVus());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu update(String id, DichVuDTO DTO) {
        DichVu dichVu = getDichVu(id);
        if (ObjectUtils.isEmpty(DTO.getMaDichVu())){
            throw new InvalidException("Mã dịch vụ không được để trống");
        }
        if (ObjectUtils.isEmpty(DTO.getTenDichVu())){
            throw new InvalidException("Tên dịch vụ không được để trống");

        }
        if (ObjectUtils.isEmpty(DTO.getNoiDung())){
            throw new InvalidException("Nội dung không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getGiaDichVus())){
            throw new InvalidException("Giá dịch vụ không được để trống");

        }
        if(!dichVu.getMaDichVu().equalsIgnoreCase(DTO.getMaDichVu())&& dichVuRepository.kiemTraMaDichVu(DTO.getMaDichVu())){
            throw new InvalidException(String.format("Dịch vụ có mã %s đã tồn tại",DTO.getMaDichVu()));
        }
        dichVu.setMaDichVu(DTO.getMaDichVu().trim());
        dichVu.setTenDichVu(DTO.getTenDichVu().trim());
        dichVu.setNoiDung(DTO.getNoiDung());
        dichVu.setGiaDichVus(DTO.getGiaDichVus());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu delete(String id) {
        DichVu dichVu = getDichVu(id);
        dichVuRepository.delete(dichVu);
        return dichVu;
    }
}
