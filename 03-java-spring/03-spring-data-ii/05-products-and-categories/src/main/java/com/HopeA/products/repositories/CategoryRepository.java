package com.HopeA.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HopeA.products.models.Category;
//import com.HopeA.products.models.Product;
import com.HopeA.products.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();

	List<Category> findByProductsNotContains(Product product);

//	List<Category> findByProduct(Product findProduct);


}
