package com.springboot.productdemo.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.productdemo.web.models.Category;
import com.springboot.productdemo.web.models.Product;
import com.springboot.productdemo.web.repositories.ICategoryRepository;

@Service
public class CategoryDao {
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	public List<Category> getAllCategories()  {
		return categoryRepository.findAll();
	}
	
	public Category save(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	public Optional<Category> getCategoryById(int categoryId) {
		return categoryRepository.findById(categoryId);
	}
	
	public void editCategory(Category category) {
		categoryRepository.save(category);
		
	}

	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
	
	

}
