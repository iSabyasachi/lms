package com.lms.accessframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class ObjectFactory {
	private static ObjectFactory INSTANCE = new ObjectFactory();
	
	private List<Object> components;
	
	@SuppressWarnings("unchecked")
	public ObjectFactory() {
		components = new ArrayList<>();
	}
	
	public ObjectFactory getInstance() {
		return INSTANCE;
	}
	public <E> void addComponent(E e) {
		Objects.requireNonNull(e);
		
		components.add(e);
	}
	public <T> Object getComponent(Class<T> type) {
		for(Object obj : components) {
			if(obj instanceof Class) return obj;
		}
		return null;
	}
	public <T> Object removeComponent(Object removeObj) {
		
		return null;
	}

}
