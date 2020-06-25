package com.springboot.productdemo.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.productdemo.web.models.Category;
import com.springboot.productdemo.web.models.Product;
import com.springboot.productdemo.web.services.CategoryMvcService;
import com.springboot.productdemo.web.services.ProductMvcService;

@Controller
//@RequestMapping(value="/mvc")
public class ProductMvcController {

	@Autowired
	ProductMvcService productMvcService;
	
	@Autowired
	CategoryMvcService categoryMvcService;

	@RequestMapping(value="/home")
	public ModelAndView loadHome(ModelAndView model) {
		model.addObject("activeWelcome","active");
		//Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		//model.addObject("ROLE", "ROLE_USER");
		//model.addObject("role", authDetail.getAuthorities());
		model.setViewName("home");
		return model;
	}
	@RequestMapping(value="/user/listproduct")
	public ModelAndView showProduct(ModelAndView model) {
		//model.addObject("role", "ROLE_USER");
		//Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		//System.out.println("Auth : " + authDetail.getAuthorities());
		//model.addObject("role", authDetail.getAuthorities());
		model.setViewName("show-product");
		model.addObject("activeUserListProduct","active");
		model.addObject("listProducts",productMvcService.retrieveAllProducts());
		model.addObject("listCategory",categoryMvcService.retrieveAllCategorys());
//		for(Product p : productMvcService.retrieveAllProducts())
//		{
//		System.out.println("productMvcService.retrieveAllProducts() - "+p.getCategory());
//		}
		System.out.println("In showProduct");
		return model;
	}
	
	@RequestMapping(value="/user/home")
	public ModelAndView loadUserHome(ModelAndView model) {	
		System.out.println("In loadUserHome");
		//Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		//model.addObject("role", authDetail.getAuthorities());
		//model.addObject("role", "ROLE_USER");
		model.setViewName("welcome");
		model.addObject("activeWelcome","active");
		return model;
	}
	
	@RequestMapping(value="/user/productByCategory")	//PathParam to get the id
	public String showProductByCategory(Model model,@PathParam("category") String category) {
		System.out.println("Category**"+category);
		if(category == null)
		{
			category = "";
		}
		if(category.equals("") || category.equalsIgnoreCase("all"))
		{
			return "redirect:/user/listproduct";
		}else {
			try {
				model.addAttribute("listProducts",productMvcService.retrieveProductByCategoryId(category));
				model.addAttribute("listCategory", categoryMvcService.retrieveAllCategorys());
			} catch (NumberFormatException | JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "show-product";
		}
	}
	
	@RequestMapping(value="/login")
	public ModelAndView getLogin() {
		ModelAndView model=new ModelAndView();
		System.out.println("In loadAdminHome");
		model.setViewName("login");
		//model.addObject("role", "ROLE_ADMIN");
		return model;
	}
	
	@RequestMapping("/")
	public ModelAndView defaultHome() {
		ModelAndView model=new ModelAndView();
		Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Auth : " + authDetail.getAuthorities()+" : "+authDetail.isAuthenticated());
			model.addObject("role", authDetail.getAuthorities());
			model.addObject("userName",authDetail.getName());
			model.setViewName("welcome");
			model.addObject("activeWelcome","active");
			return model;
	}
	
//	@RequestMapping(value="/admin/home")
//	public ModelAndView loadAdminHome(ModelAndView model) {	
//		Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
//		model.addObject("role", authDetail.getAuthorities());
//		//model.addObject("role", "ROLE_ADMIN");
//		//System.out.println("Auth : " + authDetail.getAuthorities());
//		model.addObject("userName",authDetail.getName());
//		model.setViewName("welcome");
//		model.addObject("activeWelcome","active");
//		return model;
//	}
	
	
	@RequestMapping(value="/logout")
	public ModelAndView logOutAction(ModelAndView model) {
		model.setViewName("home");
		return model;
	}
	@RequestMapping(value="/admin/listproduct")
	public ModelAndView showAdminProduct(ModelAndView model) {
		//model.addObject("role", "ROLE_ADMIN");
		Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		model.addObject("role", authDetail.getAuthorities());
		model.setViewName("show-product");
		model.addObject("listProducts",productMvcService.retrieveAllProducts());
		model.addObject("listCategory",categoryMvcService.retrieveAllCategorys());
		model.addObject("activeListProduct","active");
		model.addObject("userName",authDetail.getName());
		return model;
	}
	
	@RequestMapping(value="/admin/productByCategory")	//PathParam to get the id
	public String showProductByCategoryForAdmin(Model model,@PathParam("category") String category) {
		
		Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("role", authDetail.getAuthorities());
		model.addAttribute("userName",authDetail.getName());
		
		System.out.println("role**"+authDetail.getAuthorities());
		if(category == null)
		{
			category = "";
		}
		if(category.equals("") || category.equalsIgnoreCase("all"))
		{
			return "redirect:/admin/listproduct";
		}else {
			try {
				model.addAttribute("listProducts",productMvcService.retrieveProductByCategoryId(category));
				model.addAttribute("listCategory", categoryMvcService.retrieveAllCategorys());
			} catch (NumberFormatException | JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "show-product";
		}
	}

//	@RequestMapping(value="/admin/manageproduct")
//	public String manageAdminProduct(ModelAndView model) {
//		model.addObject("ROLE","ROLE_ADMIN");
//		model.setViewName("login");
//		return "redirect:/admin/addproduct";
//	}
	
	@RequestMapping(value="/admin/addproduct")
	public ModelAndView addProduct(ModelAndView model) {
		model.setViewName("add-product");
		//model.addObject("role", "ROLE_ADMIN");
		Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		model.addObject("role", authDetail.getAuthorities());
		model.addObject("userName",authDetail.getName());
		List<Category> listCategory=categoryMvcService.retrieveAllCategorys();
//		for(Category c : listCategory)
//		{
//			System.out.println(c.getCategoryName());
//		}
		model.addObject("listCategory",listCategory);
		model.addObject("command",new Product());
		model.addObject("reqMethod","POST");
		model.addObject("activeMngProduct","active");
		return model;
	}
	@RequestMapping(value="/admin/save")    
	public String saveProduct(@ModelAttribute("product") Product product) throws IOException{ 
		//System.out.println("Test");
		productMvcService.addProduct(product);
		return "redirect:/admin/listproduct";
	}  
	@RequestMapping(value="/admin/edit/{id}")
	public ModelAndView updateProduct(@PathVariable Integer id,Product product) {
		Product productDetailsReturnByRest = null;
		ModelAndView model = new ModelAndView("add-product");
		//model.addObject("role", "ROLE_ADMIN");
		Authentication authDetail = SecurityContextHolder.getContext().getAuthentication();
		model.addObject("role", authDetail.getAuthorities());
		model.addObject("reqMethod","PUT");
		try {
		productDetailsReturnByRest = productMvcService.retrieveProductById(id);
		List<Category> listCategory=categoryMvcService.retrieveAllCategorys();
		if(null != productDetailsReturnByRest) {
			model.addObject("listCategory",listCategory);
			model.addObject("selectrow",productDetailsReturnByRest.getCategory());
			model.addObject("command",productDetailsReturnByRest);
			model.addObject("activeMngProduct","active");
			model.addObject("userName",authDetail.getName());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/admin/editsave")    
	public String editSave(@ModelAttribute("product") Product product)throws IOException{ 
		System.out.println("In updateProductB");
		productMvcService.updateProduct(product);
		//categoryMvcService.updateCategory(product.getCategory_id());
		return "redirect:/admin/listproduct";
		
	}
	

	@RequestMapping(value="/admin/deleteProduct/{id}")
	public String deleteProduct(ModelAndView model,@PathVariable Integer id) {
		productMvcService.deleteProduct(id);
		return "redirect:/admin/listproduct";
	}

}
