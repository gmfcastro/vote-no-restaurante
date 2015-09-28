package com.bluesoft.vote.no.restaurante.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T> {
	
	protected Class<T> objType = getType();
	
	@PersistenceContext(unitName = "vote-no-restaurante")
	protected EntityManager em;
	
	public void save(T obj){
		em.persist(obj);
	}
	
	public void remove(T obj){
		em.remove(obj);
	}
	
	@SuppressWarnings({"unchecked"})
	public List<T> list(){
		CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(objType));
		return (List<T>) em.createQuery(cq).getResultList();
	}
	
	public T findById(Long id){
		return em.find(objType,id);
	}
	
	public T update(T obj){
		return em.merge(obj);
	}
	
	@SuppressWarnings({"unchecked"})
	public Class<T> getType(){
		Class<?> clas = this.getClass();
		
		while (!clas.getSuperclass().equals(GenericDAO.class)) {
			clas = clas.getSuperclass();
		}
		
		ParameterizedType genericType = (ParameterizedType) clas.getGenericSuperclass();
		return (Class<T>) genericType.getActualTypeArguments()[0];
		
	}
}
