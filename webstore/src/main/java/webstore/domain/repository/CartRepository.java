package webstore.domain.repository;

import webstore.domain.Cart;

public interface CartRepository {

	Cart read(String cartId);
	void update(Cart cart);
	void delete(Cart cart);
	
}
