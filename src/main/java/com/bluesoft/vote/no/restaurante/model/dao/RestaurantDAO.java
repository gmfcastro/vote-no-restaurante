package com.bluesoft.vote.no.restaurante.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.bluesoft.vote.no.restaurante.model.entities.Restaurant;

@Stateless
public class RestaurantDAO extends GenericDAO<Restaurant> {

	public List<Restaurant> list(){
		String str = "select r from Restaurant r where r.active = :active";
		TypedQuery<Restaurant> query = em.createQuery(str, Restaurant.class);
		query.setParameter("active", true);
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return null;
		}
	}
	
	
	public List<Restaurant> ranking(){
		String str = "select r from Restaurant r where r.active = :active order by r.votes desc";
		TypedQuery<Restaurant> query = em.createQuery(str, Restaurant.class);
		query.setParameter("active", true);
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return null;
		}
	}
	
}
