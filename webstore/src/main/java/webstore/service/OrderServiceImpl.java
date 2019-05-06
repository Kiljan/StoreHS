package webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductRepository productRepository; 
	
	@Override
	public void updateOrders(Product product) {
		productRepository.updateOrders(product);
	}

}
