package com.springboot.productdemo.web.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.productdemo.web.dao.CategoryDao;
import com.springboot.productdemo.web.models.Category;

@RestController
@RequestMapping("/rest/category")
public class CategoryResource {
	
	@Autowired
	CategoryDao categoryDao;

	@GetMapping(value = "/{categoryId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategoryId(@PathVariable(value = "categoryId") Integer categoryId) {
		Category categoryDetailById = new Category();
    	Optional<Category> categoryById = categoryDao.getCategoryById(categoryId);
    	categoryDetailById = categoryById.get();
        if(null != categoryDetailById)
        	return new ResponseEntity<Category>(categoryDetailById, new HttpHeaders(), HttpStatus.OK);
        else
        	return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
    }
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE/* ,value = "/category" */)
    public ResponseEntity<List<Category>> getAllCategorys()  {
        List<Category> categoryList = categoryDao.getAllCategories();
        return new ResponseEntity<List<Category>>(categoryList, new HttpHeaders(), HttpStatus.OK);
    }

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Category addCategory(@RequestBody Category category)
	{
		return categoryDao.save(category);
	}
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Category editCategory(@PathVariable("id") int id, @RequestBody Category category)
	{
		Category updateCategory = new Category();
		Optional<Category> categoryEntity = categoryDao.getCategoryById(category.getId());
		updateCategory = categoryEntity.get();
		if(updateCategory != null && updateCategory.getId() != 0)
		{
			categoryDao.editCategory(category);
			return category;
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Category deleteCategory(@PathVariable("id") int categoryId)
	{
		Category category = new Category();
		Optional<Category> categoryEntity = categoryDao.getCategoryById(categoryId);
		category = categoryEntity.get();
		if(category != null && category.getId() != 0)
		{
			categoryDao.deleteCategory(categoryId);
			return category;
		}
		return null;
	}
   
}
