package com.springboot.productdemo.web.resources;

import java.util.List;

import javax.validation.Valid;

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

import com.springboot.productdemo.web.dao.ProductDao;
import com.springboot.productdemo.web.models.Product;

@RestController
@RequestMapping("/rest")
public class ProductResource {

	@Autowired
	ProductDao productDao;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE/* ,value = "/product" */)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productDao.getAllProducts();
        return new ResponseEntity<List<Product>>(productList, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/{id}" )
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		System.out.println("Id in Resource : " + id);
        Product productDetailById = productDao.getProductByID(id);
        if(null != productDetailById)
        	return new ResponseEntity<Product>(productDetailById, new HttpHeaders(), HttpStatus.OK);
        else
        	return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping(/*value="/addproduct",*/consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
		Product createdProduct = productDao.createProduct(product);
        return new ResponseEntity<Product>(createdProduct, new HttpHeaders(), HttpStatus.CREATED);
    }
	
	@PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @Valid @RequestBody Product product){
		Product createdProduct = productDao.createProduct(product);
        return new ResponseEntity<Product>(createdProduct, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteStudentById(@PathVariable("id") Integer id){
    	productDao.deleteProductById(id);
        return HttpStatus.FORBIDDEN;
    }
}
