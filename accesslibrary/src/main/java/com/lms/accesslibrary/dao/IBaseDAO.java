package com.lms.accesslibrary.dao;

import com.lms.accesslibrary.entity.BaseEntity;

public interface IBaseDAO {
	void flush(); 
	
	void merge(BaseEntity data);
	
	BaseEntity saveOrUpdate(BaseEntity data);
}
