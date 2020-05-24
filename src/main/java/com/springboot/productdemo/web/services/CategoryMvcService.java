package com.springboot.productdemo.web.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.productdemo.web.models.Category;

@Service
public class CategoryMvcService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final String RESOURCE_PATH = "/rest/category";
	private String host="http://localhost";
	private String port="8080";
	private String REQUEST_URI = host + ":" + port + RESOURCE_PATH;
	
	public List<Category> retrieveAllCategorys() {
		ResponseEntity<Category[]> response = restTemplate.getForEntity(REQUEST_URI, Category[].class);
		return Arrays.asList(response.getBody());
	}

	public Category retrieveCategoryById(Integer id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
	    System.out.println("Id : " + id);
		Category updatedCategory = restTemplate.getForObject(REQUEST_URI+"/"+ id, Category.class,params); 
		return updatedCategory; 
	}

	public void addCategory(Category category) {
		HttpEntity<Category> request = new HttpEntity<Category>(category);
		restTemplate.postForObject(REQUEST_URI, request, Category.class);
	}

	public void updateCategory(Category category) {
		String UPDATED_REQUEST_URI=REQUEST_URI + "/edit/{id}";
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", category.getId());
		restTemplate.put(UPDATED_REQUEST_URI,category,params);
	}

	public void deleteCategory(Integer id) {
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.delete(REQUEST_URI +"/"+ id);
	}

}
