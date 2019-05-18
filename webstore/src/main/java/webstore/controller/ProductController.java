package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webstore.domain.Product;
import webstore.exception.NoProductsFoundUnderCategoryException;
import webstore.exception.ProductNotFoundException;
import webstore.service.ProductService;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		
		List<Product> products = productService.getProductByCategory(productCategory);
		if(products == null || products.isEmpty()) {
			throw new  NoProductsFoundUnderCategoryException();
		}
		
		model.addAttribute("products", products);
		return "products";
	}

	/*
	 * Example url
	 * http://localhost:8080/webstore/products/filter/ByCriteria;brand=Nexus;category=Tablet
	 * Dont whan to use especialy in spring security
	 */
		//	@RequestMapping("/filter/{ByCriteria}")
		//	public String getProductByFilter(Model model,
		//			@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams) {
		//		model.addAttribute("products", productService.getProductByFilter(filterParams));
		//		return "products";
		//	}

	/*
	 * Example url http://localhost:8080/webstore/products/product?id=P1234
	 */
	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") int productId) {
		model.addAttribute("products", productService.getProductById(productId));
		return "product";
	}

	/*
	 * Orders set
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updateProductOrderById(@PathVariable int id) {
		Product product = productService.getProductById(id);
		return new ModelAndView("editProductOrder", "prodOrd", product);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updateProductOrderByIdSave(@ModelAttribute("prodOrd") Product product) {
		productService.updateOrders(product);
		return "redirect:/products";
	}

	/*
	 * Add product == only for admin
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product product, 
			Errors errors) {
		
		
		if(errors.hasErrors())
			return "addProduct";
		
		productService.addProduct(product);
		return "redirect:/products";
	}
	
	/*
	 * Error handling on missing products
	 * */

	@ExceptionHandler(ProductNotFoundException.class)
	public	ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("invalidProductId", exception.getProductId());
			mav.addObject("exception", exception);
			mav.addObject("url",req.getRequestURL()+"?"+req.getQueryString());
			mav.setViewName("productNotFound");
			return	mav;
	}
	
}
