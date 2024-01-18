package com.example.PhamVanHau_Product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.PhamVanHau_Product.entity.Product;
import com.example.PhamVanHau_Product.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	@GetMapping("/index")
	public String index(Model model) {
		List<Product> products = service.getAllProduct();
		model.addAttribute("products", products);
		return "index";
	}
	@GetMapping("/create")
	public String showCreate(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "create";
	}
	@PostMapping("/submit")
	public String add(@ModelAttribute("product") Product product) {
		service.add(product);
		return "redirect:index";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		service.delete(id);
		return "redirect:index";
	}
	@GetMapping("/update")
	public String showUpdate(@RequestParam("id") int id, Model model) {
		Product product = service.getProductById(id);
		model.addAttribute("product", product);
		return "update";
	}
	@PostMapping("/update-submit")
	public String update(@ModelAttribute("product") Product product) {
		service.update(product);
		return "redirect:index";
	}
	@GetMapping("/findAll")
	public List<Product> findAll(){
		return service.getAllProduct();
	}
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		return service.add(product);
	}
}
