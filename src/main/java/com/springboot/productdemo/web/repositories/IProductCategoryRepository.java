package com.springboot.productdemo.web.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.productdemo.web.models.Product;
import com.springboot.productdemo.web.models.Category;

@Repository
public interface IProductCategoryRepository extends JpaRepository<Category, Integer>{
	//List<Category> findByProducts(Set<Product> products);
	
}
