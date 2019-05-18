package webstore.domain.repository;

import org.hibernate.SessionFactory;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webstore.domain.Cart;


@Repository
public class InMemoryCartRepository implements CartRepository{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@Override
	public Cart read(String cartId) {
		return (Cart) getCurrentSession().get(Cart.class, cartId);
	}

	@Override
	public void update(Cart cart) {
		Cart cartToUpdate = read(cart.getCartId());
		cartToUpdate.setGrandTotal(cart.getGrandTotal().add(new BigDecimal(1)));
		getCurrentSession().update(cartToUpdate);
	}

	@Override
	public void delete(Cart cart) {
		Cart cartToDelete = read(cart.getCartId());
		if(cartToDelete != null)
			getCurrentSession().delete(cartToDelete);
	}

}
