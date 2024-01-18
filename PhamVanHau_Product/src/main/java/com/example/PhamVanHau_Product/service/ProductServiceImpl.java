package com.example.PhamVanHau_Product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PhamVanHau_Product.dao.ProductDao;
import com.example.PhamVanHau_Product.entity.Product;

import jakarta.transaction.Transactional;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao dao;
	@Transactional
	@Override
	public List<Product> getAllProduct() {
		return dao.findAll();
	}
	@Transactional
	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}
	@Transactional
	@Override
	public Product getProductById(int id) {
		return dao.getById(id);
	}
	@Transactional
	@Override
	public Product add(Product product) {
		return dao.save(product);
	}
	@Transactional
	@Override
	public Product update(Product product) {
		return dao.save(product);
	}

}
