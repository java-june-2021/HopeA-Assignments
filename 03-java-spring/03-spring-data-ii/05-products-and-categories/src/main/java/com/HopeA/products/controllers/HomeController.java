package com.HopeA.products.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HopeA.products.models.Category;
import com.HopeA.products.models.Product;
import com.HopeA.products.services.ShoppingService;

@Controller

public class HomeController {
	@Autowired
	private ShoppingService sService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("products", this.sService.allProducts());
		return "index.jsp";
	}
	
	//Product Mapping
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		}
		this.sService.createProduct(product);
		return "redirect:/";
		
	}
	
	@GetMapping("/product/{id}")
	public String showProducts(@PathVariable("id") Long id, Model viewModel) {
		
		viewModel.addAttribute("product", this.sService.findProduct(id));
		viewModel.addAttribute("category", this.sService.findCategoriesNotInProduct(this.sService.findProduct(id)));
		return "products.jsp";
	}
	
	//Category Mapping
	
	@GetMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/category/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		}
		this.sService.createCategory(category);
		return "redirect:/";
		
	}
	
	@GetMapping("/category/{id}")
	public String showCategories(@PathVariable("id") Long id, Model viewModel) {
		
		viewModel.addAttribute("category", this.sService.findCategory(id));
		viewModel.addAttribute("product", this.sService.findProductsNotInCategory(this.sService.findCategory(id)));
		return "category.jsp";
	}
	
	@PostMapping("/product/{id}")
	public String addCategoryToProduct(@RequestParam("showCat") Long catId, @PathVariable("id") Long id) {
		Product product = this.sService.findProduct(id);
		Category category = this.sService.findCategory(catId);
		this.sService.addCategory(category, product);
		return "redirect:/product/{id}";
	}
	
	
	@PostMapping("/category/{id}")
	public String addProductToCategory(@RequestParam("showPro") Long proId, @PathVariable("id") Long id) {
		Category category = this.sService.findCategory(id);
		Product product = this.sService.findProduct(proId);
		this.sService.addProduct(product, category);
		return "redirect:/category/{id}";
	}

}
