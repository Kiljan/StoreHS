package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webstore.domain.Product;
import webstore.service.OrderService;
import webstore.service.ProductService;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;

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
		model.addAttribute("products", productService.getProductByCategory(productCategory));
		return "products";
	}
	/*
	 * Example url
	 * http://localhost:8080/webstore/products/filter/ByCriteria;brand=Nexus;category=Tablet*/
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductByFilter(Model model, @MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams) {
		model.addAttribute("products", productService.getProductByFilter(filterParams));
		return "products";
	}
	
	/*
	 * Example url
	 * http://localhost:8080/webstore/products/product?id=P1234
	 * */
	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") int productId) {
		model.addAttribute("products", productService.getProductById(productId));
		return "product";
	}
	
	/*
	 * Orders set
	 * */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updateProductOrderById(@PathVariable int id){		
		Product product = productService.getProductById(id);
		return new ModelAndView("editProductOrder", "prodOrd", product);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView updateProductOrderByIdSave(@ModelAttribute("prodOrd") Product product, @PathVariable int id) {
		ModelAndView mav = new ModelAndView("product");
		orderService.updateOrders(product);
		return mav;
	}
	
	
}















