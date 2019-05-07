package webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import webstore.domain.*;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	Product getProductByID(int productId);
	List<Product> getProductByCategory(String category);
	Set<Product> getProductByFilter (Map<String, List<String>> filterParams);
	void updateOrders(Product product);
	void addProduct(Product	product);
}
