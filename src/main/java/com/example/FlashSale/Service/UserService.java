package com.example.FlashSale.Service;

import com.example.FlashSale.DTO.UserDTO;

public interface UserService {
    UserDTO findById(Long id);
}
