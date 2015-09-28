package com.bluesoft.vote.no.restaurante.controller;

import java.util.List;
import static br.com.caelum.vraptor.view.Results.json;

import javax.inject.Inject;

import com.bluesoft.vote.no.restaurante.model.dao.RestaurantDAO;
import com.bluesoft.vote.no.restaurante.model.entities.Restaurant;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;

@Controller
public class IndexController {
	
	private Result result;
	private RestaurantDAO restaurantDAO;
	
	/**
     * CDI eyes only
     * @deprecated
     */
	public IndexController() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	public IndexController(Result result, RestaurantDAO restaurantDAO){
		this.result = result;
		this.restaurantDAO = restaurantDAO;
	}
	
	@Get
	@Path(value={"/",""})
	public void index() {
		
		List<Restaurant> allRestaurantes = restaurantDAO.list();

		if(allRestaurantes.isEmpty()){
			createRestaurants();
		}
		
	}
	
	@Get
	@Path(value="/restaurants")
	public void restaurantes(){
		
		List<Restaurant> allRestaurantes = restaurantDAO.list();
		
		result.use(json()).withoutRoot().from(allRestaurantes).serialize();
		
	}
	
	@Post
	@Path(value="/vote")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	public Restaurant vote(Restaurant r){
		
		r = restaurantDAO.findById(r.getId());
		
		if(r!= null){
			r.setVotes(r.getVotes()+1);
			
			r = restaurantDAO.update(r);
			
			result.use(json()).withoutRoot().from(r).serialize();
		}
		
		return r;
	}
	
	private void createRestaurants(){
		
		Restaurant r;
		
		r = new Restaurant("McDonalds");
		restaurantDAO.save(r);
		
		r = new Restaurant("Burger King");
		restaurantDAO.save(r);
		
		r = new Restaurant("Outback");
		restaurantDAO.save(r);
		
		r = new Restaurant("Bobs");
		restaurantDAO.save(r);
		
		r = new Restaurant("Subway");
		restaurantDAO.save(r);
	}
}
