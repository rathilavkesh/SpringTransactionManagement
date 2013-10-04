package com.lavkesh.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
public abstract class HibernateDAO<T> implements DAO<T> {

	private SessionFactory sessionFactory;

	private Class<T> type;

	public HibernateDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T findById(Serializable id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (T) session.get(type, id);
	}

	@Override
	public <E> E findById(Serializable id, Class<E> obj) {
		Session session = this.sessionFactory.getCurrentSession();
		return (E) session.get(obj, id);
	}

	@Override
	public <E> E save(T t, Class<E> obj) {
		Session session = this.sessionFactory.getCurrentSession();
		return (E) session.save(t);
	}

	@Override
	public void delete(Object t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public List<T> findByParameter(Map<String, Object> properties) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(type);
		return null;
	}

	@Override
	public <E> List<E> findByParameter(Map<String, Object> properties,
			Class<E> obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}

}