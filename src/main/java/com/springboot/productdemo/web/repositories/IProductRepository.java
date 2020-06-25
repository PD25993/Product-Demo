package com.springboot.productdemo.web.repositories;

import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.productdemo.web.models.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
	//List<Product> findByCategory_id(Integer category_id);
	List<Product> findByCategoryId(Integer category);//CategoryId - product table mapped name || category - product class var name
	//findProductByCategoryId(int category_id);

}
