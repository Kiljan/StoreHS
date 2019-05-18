package webstore.domain.repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import webstore.domain.Product;
import webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		return getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public Product getProductByID(int productId) {
		
		Product pr = (Product) getCurrentSession().get(Product.class, productId);
		
		if(pr == null) 
			throw new ProductNotFoundException(productId);
		
		return pr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByCategory(String category) {
		return getCurrentSession().createQuery("from Product where category = '" + category + "'").list();
	}

	@Override
	public Set<Product> getProductByFilter(Map<String, List<String>> filterParams) {

		@SuppressWarnings("unchecked")
		List<Product> listOfProducts = getCurrentSession().createQuery("from Product").list();
		Set<Product> productByBrand = new HashSet<Product>();
		Set<Product> productByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productByBrand.add(product);
					}
				}
			}
		}

		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productByCategory.addAll(this.getProductByCategory(category));
			}
		}

		productByCategory.retainAll(productByBrand);

		return productByCategory;
	}

	@Override
	public void updateOrders(Product product) {
		Product productToUpdate = getProductByID(product.getProductId());
		long value = product.getUnitsInStock() - product.getUnitsInOrder();
		productToUpdate.setUnitsInStock(value);
		getCurrentSession().update(productToUpdate);
	}
	
	@Override
	public void updateTotalPrice(Product product, BigDecimal quantity) {
		Product productToUpdate = getProductByID(product.getProductId());
		BigDecimal value = product.getUnitPrice().multiply(quantity);
		productToUpdate.setUnitPrice(value);
		getCurrentSession().update(productToUpdate);
	}

	@Override
	public void addProduct(Product product) {
		getCurrentSession().save(product);

	}

}