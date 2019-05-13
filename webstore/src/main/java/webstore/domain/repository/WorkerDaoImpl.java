package webstore.domain.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webstore.domain.Worker;

@Repository
public class WorkerDaoImpl implements WorkerDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Worker selectOne(String username) {
		return (Worker) getCurrentSession().get(Worker.class, username);
	}

}
