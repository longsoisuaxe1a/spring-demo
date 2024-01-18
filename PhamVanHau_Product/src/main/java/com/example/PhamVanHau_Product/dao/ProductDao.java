package com.example.PhamVanHau_Product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PhamVanHau_Product.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
