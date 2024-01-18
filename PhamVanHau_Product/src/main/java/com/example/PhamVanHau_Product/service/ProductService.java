package com.example.PhamVanHau_Product.service;

import java.util.List;

import com.example.PhamVanHau_Product.entity.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public void delete(int id);
	public Product getProductById(int id);
	public Product add(Product product);
	public Product update(Product product);
}
