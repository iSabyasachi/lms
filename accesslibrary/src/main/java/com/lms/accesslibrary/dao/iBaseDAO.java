package com.lms.accesslibrary.dao;

import com.lms.accesslibrary.entity.library.BaseEntity;

public interface iBaseDAO {
	void flush();
	
	void merge(BaseEntity data);
	
	BaseEntity saveOrUpdate(BaseEntity data);
}
