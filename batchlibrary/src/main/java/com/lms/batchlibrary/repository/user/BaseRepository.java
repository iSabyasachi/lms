package com.lms.batchlibrary.repository.user;

import java.util.List;

public interface BaseRepository<E> {
	void saveAll(List<E> users);
}
