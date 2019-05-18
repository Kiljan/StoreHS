package webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstore.domain.Cart;
import webstore.domain.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart read(String cartId) {
		return cartRepository.read(cartId);
	}

	@Override
	public void update(Cart cart) {
		cartRepository.update(cart);
	}

	@Override
	public void delete(Cart cart) {
		cartRepository.delete(cart);		
	}

}
