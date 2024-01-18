package com.example.PhamVanHau_User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.PhamVanHau_User.entity.UserName;
import com.example.PhamVanHau_User.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/index")
	public String index(Model model) {
		List<UserName> users = service.findAll();
		model.addAttribute("users", users);
		return "index";
	}
	@GetMapping("/create")
	public String showCreate(Model model) {
		UserName user = new UserName();
		model.addAttribute("user", user);
		return "create";
	}
	@PostMapping("/submit")
	public String add(@ModelAttribute("user") UserName user) {
		service.save(user);
		return "redirect:index";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		service.deleteById(id);
		return "redirect:index";
	}
	@GetMapping("/update")
	public String showUpdate(@RequestParam("id") int id, Model model) {
		UserName user = service.getById(id);
		model.addAttribute("user", user);
		return "update";
	}
	@PostMapping("/update-submit")
	public String update(@ModelAttribute("user") UserName user) {
		service.save(user);
		return "redirect:index";
	}
}
