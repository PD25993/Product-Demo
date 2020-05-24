package com.springboot.productdemo.web.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category { 
	@Id
	@Column(name = "category_id")
	private Integer id;
	private String categoryName;
	@OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
	private Set<Product> products;
	
	public Integer getId() {
		return id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public Set<Product> getProducts() {
		return null;
	}
	
	

}
