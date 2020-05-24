package com.springboot.productdemo.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString -- JSON error 
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Size(min=3, message="Please provide atleast 3 characters")
	private String productCode;
	@NotBlank
	@NotNull
	private String productName;
	@DecimalMin(value = "0.1")
	@Positive
	@NotNull
	private Double productPrice;
	@ManyToOne
    @JoinColumn(name = "category_id")
	//@JsonIgnore	
	private Category category_id;
		
}
