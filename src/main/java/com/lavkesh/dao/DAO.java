package com.lavkesh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DAO<T> {

	T findById(Serializable id);
	<E> E findById(Serializable id, Class<E> obj);
	
	void  saveOrUpdate(Object t) ;
    
    void delete(Object t);
    
    List<T> findByParameter(Map<String, Object> properties);
    <E> List<E> findByParameter(Map<String, Object> properties, Class<E> obj);
    
} 