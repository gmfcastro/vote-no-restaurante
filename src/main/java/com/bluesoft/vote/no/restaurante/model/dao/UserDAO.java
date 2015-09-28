package com.bluesoft.vote.no.restaurante.model.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.bluesoft.vote.no.restaurante.model.entities.User;

@Stateless
public class UserDAO extends GenericDAO<User>{

	public User findByEmail(String email){
		String str = "select u from User u where u.active = :active and u.email = :email";
		TypedQuery<User> query = em.createQuery(str, User.class);
		query.setParameter("active", true);
		query.setParameter("email", email);
		
		try{
			return query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	
}
