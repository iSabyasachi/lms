package com.lms.batchlibrarymongo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserAddress {
	private static int instances = 0;
	private int id;
	
	public UserAddress() {
		instances++;
		System.out.println("UserAddress constructor called");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static int getInstances(){
        return UserAddress.instances;
	}
	
	@PostConstruct
    private void postConstruct() {
    	System.out.println("UserAddress Post Constructor called");
    }
    
    @PreDestroy
    private void preDestroy() {
    	System.out.println("UserAddress Pre Destory called");
    }
}
