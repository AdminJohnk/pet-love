package com.example.backend.services.datcho;

import com.example.backend.dtos.datcho.DatChoDTO;
import com.example.backend.entities.DatCho;
import com.example.backend.exceptions.InvalidException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.repositories.DatChoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DatChoServiceImpl implements DatChoService{
    private final DatChoRepository datChoRepository;

    public DatChoServiceImpl(DatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @Override
    public DatCho getDatCho(String id) {
        return datChoRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("Không tồn tại đặt chổ có id là: %s",id)));
    }

    @Override
    public DatCho create(DatChoDTO DTO) {
        if(ObjectUtils.isEmpty(DTO.getEmail())){
            throw new InvalidException("Email không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getThongTinDatChos())){
            throw new InvalidException("Thông tin đặt chổ khong được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getThoiGian())){
            throw new InvalidException("Thời gian không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getCanDan())){
            throw new InvalidException("căn dặn không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getTrangThaiDatCho())){
            throw new InvalidException("Trạng thái đặt chỗ không được để trống");
        }
        DatCho datCho = new DatCho();
        datCho.setEmail(DTO.getEmail().trim());
        datCho.setThongTinDatChos(DTO.getThongTinDatChos());
        datCho.setThoiGian(DTO.getThoiGian());
        datCho.setCanDan(DTO.getCanDan().trim());
        datCho.setTrangThaiDatCho(DTO.getTrangThaiDatCho());
        datChoRepository.save(datCho);
        return datCho;
    }

    @Override
    public DatCho update(String id, DatChoDTO DTO) {
        DatCho datCho = getDatCho(id);
        if(ObjectUtils.isEmpty(DTO.getEmail())){
            throw new InvalidException("Email không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getThongTinDatChos())){
            throw new InvalidException("Thông tin đặt chổ khong được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getThoiGian())){
            throw new InvalidException("Thời gian không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getCanDan())){
            throw new InvalidException("căn dặn không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getTrangThaiDatCho())){
            throw new InvalidException("Trạng thái đặt chỗ không được để trống");
        }

        datCho.setEmail(DTO.getEmail().trim());
        datCho.setThongTinDatChos(DTO.getThongTinDatChos());
        datCho.setThoiGian(DTO.getThoiGian());
        datCho.setCanDan(DTO.getCanDan().trim());
        datCho.setTrangThaiDatCho(DTO.getTrangThaiDatCho());
        datChoRepository.save(datCho);
        return datCho;
    }

    @Override
    public DatCho delete(String id) {
        DatCho datCho = getDatCho(id);
        datChoRepository.delete(datCho);
        return null;
    }
}
