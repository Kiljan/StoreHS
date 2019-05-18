package webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import webstore.domain.Cart;
import webstore.domain.Product;
import webstore.service.CartService;
import webstore.service.ProductService;

@Controller
@RequestMapping(value = "rest/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable("cartId") String cartId, HttpServletRequest request) {
		System.out.println(request.getSession(true).getId());
		return cartService.read(cartId);
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable("cartId") String cartId) {
		Cart cart = cartService.read(cartId);
		cartService.update(cart);
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("cartId") String cartId) {
		Cart cart = cartService.read(cartId);
		cartService.delete(cart);		
	}
	
	@RequestMapping(value = "/add/{productID}/{cardId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public @ResponseBody Product addItem(@PathVariable("productID") int productId, @PathVariable("cardId") String cardId) {
		
		Cart cart = cartService.read(cardId);
		Product product = productService.getProductById(productId);
		
		if(cart == null || product == null) {
			throw new IllegalArgumentException();
		}
		
		productService.updateTotalPrice(product, cart.getGrandTotal());
		
		return productService.getProductById(productId);
	}
}















