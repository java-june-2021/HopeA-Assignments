package com.HopeA.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HopeA.products.models.Category;
import com.HopeA.products.models.Product;
import com.HopeA.products.repositories.CategoryRepository;
import com.HopeA.products.repositories.ProductRepository;

@Service

public class ShoppingService {
	@Autowired
	private ProductRepository pRepo;
	@Autowired
	private CategoryRepository cRepo;
	
	
//	//FIND ALL
	public List<Product> allProducts() {
		return this.pRepo.findAll();
	}
//	
	public List<Category> allCategories() {
		return this.cRepo.findAll();
	}
//	
//	//FIND ONE
//	
	public Product findProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
//	
	public Category findCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
//	public List<Category>findByProduct(Long id) {
//		return this.cRepo.findByProduct(findProduct(id));
//	}
//	
//	//Create
//	
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
//
	public Category createCategory(Category newCategory) {
		return this.cRepo.save(newCategory);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
//	public List<Category> findCategoriesNotInProduct(Category category) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public void addProduct(Product product, Category category) {
		List<Product> products = category.getProducts();
		products.add(product);
		this.cRepo.save(category);
		
	}
	
	public void addCategory(Category category, Product product) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		this.pRepo.save(product);
		
	}
	
}
