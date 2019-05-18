package webstore.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import webstore.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(int productId);

	List<Product> getProductByCategory(String category);

	Set<Product> getProductByFilter(Map<String, List<String>> filterParams);

	public void updateOrders(Product product);

	void updateTotalPrice(Product product, BigDecimal quantity);
	
	void addProduct(Product product);
}
