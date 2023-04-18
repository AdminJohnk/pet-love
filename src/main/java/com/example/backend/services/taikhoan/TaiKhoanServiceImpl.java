package com.example.backend.services.taikhoan;

import com.example.backend.dtos.taikhoan.TaiKhoanDTO;
import com.example.backend.entities.TaiKhoan;
import com.example.backend.exceptions.InvalidException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.repositories.TaiKhoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{

    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanServiceImpl(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public TaiKhoan getTaiKhoan(String id) {
        return taiKhoanRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Tài khoản có mã id là %s đã tồn tại",id)));
    }

    @Override
    public TaiKhoan create(TaiKhoanDTO DTO) {

        if(ObjectUtils.isEmpty(DTO.getName())){
            throw new InvalidException("Tên tài khoản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getEmail())){
            throw new InvalidException("Địa chỉ email không được bỏ trống");

        }
        if(ObjectUtils.isEmpty(DTO.getPassword())){
            throw new InvalidException("Mật khẩu không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getDienThoai())){
            throw new InvalidException("Số điện thoại không đươc bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getRoles())){
            throw new InvalidException("Role không được bỏ trống");

        }
        if(taiKhoanRepository.kiemtraEmail(DTO.getEmail().trim())){
            throw new InvalidException(String.format("Địa chỉ email: %s đã tồn tại",DTO.getEmail()));
        }
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setName(DTO.getName().trim());
        taiKhoan.setEmail(DTO.getEmail().trim());
        taiKhoan.setPassword(DTO.getPassword());
        taiKhoan.setDienThoai(DTO.getDienThoai().trim());
        taiKhoan.setRoles(DTO.getRoles());
        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public TaiKhoan update(String id, TaiKhoanDTO DTO) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        if(ObjectUtils.isEmpty(DTO.getName())){
            throw new InvalidException("Tên tài khoản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getEmail())){
            throw new InvalidException("Địa chỉ email không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getPassword())){
            throw new InvalidException("Mật khẩu không được để trống");

        }
        if(ObjectUtils.isEmpty(DTO.getDienThoai())){
            throw new InvalidException("Số điện thoại không đươc bỏ trống");

        }
        if(ObjectUtils.isEmpty(DTO.getRoles())){
            throw new InvalidException("Role không được bỏ trống");
        }
        if(!taiKhoan.getEmail().equalsIgnoreCase(DTO.getEmail().trim()) && taiKhoanRepository.kiemtraEmail(DTO.getEmail().trim())){
            throw new InvalidException(String.format("Địa chỉ email: %s đã tồn tại",DTO.getEmail()));
        }
        taiKhoan.setName(DTO.getName().trim());
        taiKhoan.setEmail(DTO.getEmail().trim());
        taiKhoan.setPassword(DTO.getPassword());
        taiKhoan.setDienThoai(DTO.getDienThoai().trim());
        taiKhoan.setRoles(DTO.getRoles());
        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public TaiKhoan delete(String id) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        taiKhoanRepository.delete(taiKhoan);
        return null;
    }
}
