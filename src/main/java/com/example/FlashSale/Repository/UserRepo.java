package com.example.FlashSale.Repository;

import com.example.FlashSale.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
