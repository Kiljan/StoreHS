package webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstore.domain.Worker;
import webstore.domain.repository.WorkerDao;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	private WorkerDao workerDao;
	
	@Override
	public Worker selectOne(String username) {
		return workerDao.selectOne(username);
	}

}
