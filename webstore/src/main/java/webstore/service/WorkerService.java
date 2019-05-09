package webstore.service;

import webstore.domain.Worker;

public interface WorkerService {
	Worker selectOne(String username);
}
