package com.springboot.productdemo.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.productdemo.web.models.Product;
import com.springboot.productdemo.web.repositories.IProductRepository;

@Service
public class ProductDao {

	@Autowired
	IProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> listProducts= new ArrayList<Product>(); 
		listProducts = productRepository.findAll();
		return listProducts;
	}

	public Product getProductByID(Integer id)
	{
		Optional<Product> productDetailsFindById = productRepository.findById(id);
		if(productDetailsFindById.isPresent()) {
			return productDetailsFindById.get();
		}else {
			return null;
		}
	}

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

	public void deleteProductById(Integer id)
	{
		Optional<Product> productDetailsFindById = productRepository.findById(id);

		if(productDetailsFindById.isPresent())
		{
			productRepository.deleteById(id);
		} 
	}

}
