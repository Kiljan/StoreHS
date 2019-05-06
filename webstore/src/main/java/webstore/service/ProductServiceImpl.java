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
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int productId) {
		return productRepository.getProductByID(productId);
	}

	@Override
	@Transactional
	public List<Product> getProductByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}

	@Override
	@Transactional
	public Set<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductByFilter(filterParams);
	}
	
	@Transactional
	public void updateOrders(Product product) {
		productRepository.updateOrders(product);
	}
	

}
