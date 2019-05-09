package webstore.domain.repository;

import webstore.domain.Worker;

public interface WorkerDao {
	Worker selectOne(String username);
}
