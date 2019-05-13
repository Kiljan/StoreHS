package webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(int productId) {
		return productRepository.getProductByID(productId);
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}

	@Override
	public Set<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductByFilter(filterParams);
	}

	public void updateOrders(Product product) {
		productRepository.updateOrders(product);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

}
