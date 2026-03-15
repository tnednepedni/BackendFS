package com.example.FlashSale.Service.impl;

import com.example.FlashSale.DTO.UserDTO;
import com.example.FlashSale.Entity.User;
import com.example.FlashSale.Repository.UserRepo;
import com.example.FlashSale.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public UserDTO findById(Long id) {
        User user = userRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Khong tim thay User: " + id));
        return modelMapper.map(user, UserDTO.class);
    }
}
