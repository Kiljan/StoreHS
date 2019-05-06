package webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import webstore.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getProductById(int productId);
	List<Product> getProductByCategory(String category);
	Set<Product> getProductByFilter (Map<String, List<String>> filterParams);
	void updateOrders(Product product);

}
