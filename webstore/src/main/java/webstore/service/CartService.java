package webstore.service;

import webstore.domain.Cart;

public interface CartService {

	Cart read(String cartId);
	void update(Cart cart);
	void delete(Cart cart);
}
