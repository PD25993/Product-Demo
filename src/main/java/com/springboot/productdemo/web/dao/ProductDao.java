package com.springboot.productdemo.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springboot.productdemo.web.models.Product;
import com.springboot.productdemo.web.repositories.IProductRepository;

@Service
public class ProductDao {

	@Autowired
	IProductRepository productRepository;

	// @Cacheable annotation adds the caching behaviour. 
    // If multiple requests are received, then the method won't be repeatedly executed, instead, the results are shared from cached storage.
	@Cacheable(value="product-cache") 
	//condition = "#isCacheable != null && #isCacheable") - we can provide condition 
	public List<Product> getAllProducts()  {
		//Thread.sleep(4000);
		List<Product> listProducts= new ArrayList<Product>(); 
		listProducts = productRepository.findAll();
		return listProducts;
	}

	@Cacheable(value="product-cache",key = "'ProductInCache'+#id") 
	public Product getProductByID(Integer id)
	{
		Optional<Product> productDetailsFindById = productRepository.findById(id);
		if(productDetailsFindById.isPresent()) {
			return productDetailsFindById.get();
		}else {
			return null;
		}
	}

	@CachePut(value="product-cache")
	public Product createProduct(Product productEntity) 
	{
		if(null != productEntity.getId())
		{
			Optional<Product> productDetailsFindById = productRepository.findById(productEntity.getId());

			if(productDetailsFindById.isPresent())
			{
				Product newEntity = productDetailsFindById.get();
				newEntity.setId(productEntity.getId());
				newEntity.setProductName(productEntity.getProductName());
				newEntity.setProductCode(productEntity.getProductCode());
				newEntity.setProductCategory(productEntity.getProductCategory());
				newEntity.setProductPrice(productEntity.getProductPrice());

				newEntity = productRepository.saveAndFlush(newEntity);

				return newEntity;
			} else {
				productEntity = productRepository.saveAndFlush(productEntity);

				return productEntity;
			}
		}
		else
		{
			productEntity = productRepository.saveAndFlush(productEntity);
			return productEntity;
		}	    
	}


	@CachePut(value="product-cache")
	public Product updateProductById(Integer id, Product productEntity) 
	{
		Optional<Product> productDetailsFindById = productRepository.findById(id);

		if(productDetailsFindById.isPresent())
		{
			Product existingProduct= productDetailsFindById.get();
			existingProduct.setId(productEntity.getId());
			existingProduct.setProductName(productEntity.getProductName());
			existingProduct.setProductCode(productEntity.getProductCode());
			existingProduct.setProductCategory(productEntity.getProductCategory());
			existingProduct.setProductPrice(productEntity.getProductPrice());

			existingProduct = productRepository.save(existingProduct);

			return existingProduct;
		} else {

			return null;
		}	    
	}

	@CacheEvict(value="product-cache")
	public void deleteProductById(Integer id)
	{
		Optional<Product> productDetailsFindById = productRepository.findById(id);

		if(productDetailsFindById.isPresent())
		{
			productRepository.deleteById(id);
		} 
	}

}
