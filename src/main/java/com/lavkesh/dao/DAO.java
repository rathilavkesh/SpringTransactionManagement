package com.lavkesh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DAO<T> {

	T findById(Serializable id);
	<E> E findById(Serializable id, Class<E> obj);
	
	<E> E save(T t, Class<E> obj);
    
    void delete(Object t);
    
    List<T> findByParameter(Map<String, Object> properties);
    <E> List<E> findByParameter(Map<String, Object> properties, Class<E> obj);
    
} 