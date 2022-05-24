package com.lms.accesslibrary.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lms.accesslibrary.entity.library.BaseEntity;

public abstract class BaseDAO implements iBaseDAO{	
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public void flush() {
		entityManager.flush();		
	}

	@Override
	public void merge(BaseEntity data) {
		entityManager.merge(data);		
	}

	@Override
	public BaseEntity saveOrUpdate(BaseEntity data) {
		return entityManager.merge(data);
		
	}
		
}
