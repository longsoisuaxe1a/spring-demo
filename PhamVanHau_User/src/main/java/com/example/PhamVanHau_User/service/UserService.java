package com.example.PhamVanHau_User.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PhamVanHau_User.entity.UserName;

public interface UserService extends JpaRepository<UserName, Integer>{

}
