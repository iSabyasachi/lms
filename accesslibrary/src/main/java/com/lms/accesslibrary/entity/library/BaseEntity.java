package com.lms.accesslibrary.entity.library;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntity {	
	
	private Timestamp createdTS;
	private Timestamp updatedTS;
	
	@Column(name="date_created", nullable = false)	
	public Timestamp getCreatedTS() {
		return createdTS;
	}
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}
	
	@Column(name="last_updated", nullable = false)	
	public Timestamp getUpdatedTS() {
		return updatedTS;
	}
	public void setUpdatedTS(Timestamp updatedTS) {
		this.updatedTS = updatedTS;
	}
	
	@PreUpdate
	@PrePersist
	public void onInterceptorInsert() {
		this.setCreatedTS(Timestamp.from(Instant.now()));
		this.setUpdatedTS(Timestamp.from(Instant.now()));
	}

}
