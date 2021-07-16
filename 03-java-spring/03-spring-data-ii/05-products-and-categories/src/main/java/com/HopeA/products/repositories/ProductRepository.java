package com.HopeA.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HopeA.products.models.Category;
import com.HopeA.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long> {
	List<Product> findAll();

	List<Product> findByCategoriesNotContains(Category category);

}
