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

import com.springboot.productdemo.web.models.Product;

@Service
public class ProductMvcService {

	@Autowired
	RestTemplate restTemplate;
	
	//RestTemplate restTemplate=new RestTemplate();

	private static final String RESOURCE_PATH = "/rest/product";
	private String host="http://localhost";
	private String port="8080";
	private String REQUEST_URI = host + ":" + port + RESOURCE_PATH;


	public List<Product> retrieveAllProducts() {
		/*
		 * List<Product> allProductsList = new ArrayList<Product>();
		 * allProductsList.add(new Product("100", "Mobil1", 300.50, "Elctronics"));
		 * return allProductsList;
		 */
		//RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<Product[]> response = restTemplate.getForEntity(REQUEST_URI, Product[].class);
		return Arrays.asList(response.getBody());
	}


	public Product retrieveProductById(Integer id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", id);
	    System.out.println("Id : " + id);
		//RestTemplate restTemplate=new RestTemplate(); 
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
//		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		Product updatedProduct = restTemplate.getForObject(REQUEST_URI+"/"+ id, Product.class,params); 
		return updatedProduct; 
	}

	public void addProduct(Product product) {
		//RestTemplate restTemplate=new RestTemplate();
		/*
		 * ResponseEntity<HttpStatus> response = restTemplate.postForEntity(REQUEST_URI,
		 * product, HttpStatus.class); return response.getBody();
		 */
		HttpEntity<Product> request = new HttpEntity<Product>(product);
		restTemplate.postForObject(REQUEST_URI, request, Product.class);
	}

	public void updateProduct(Product product) {
		//RestTemplate restTemplate=new RestTemplate();
		String UPDATED_REQUEST_URI=REQUEST_URI + "/edit/{id}";
		System.out.println("UPDATED_REQUEST_URI : " + UPDATED_REQUEST_URI + " : "+ product.getId());
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", product.getId());
		restTemplate.put(UPDATED_REQUEST_URI,product,params);
	}

	public void deleteProduct(Integer id) {
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.delete(REQUEST_URI +"/"+ id);

	}
}
