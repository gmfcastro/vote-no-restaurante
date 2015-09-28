package com.bluesoft.vote.no.restaurante.controller;

import java.util.List;

import javax.inject.Inject;

import com.bluesoft.vote.no.restaurante.model.dao.RestaurantDAO;
import com.bluesoft.vote.no.restaurante.model.entities.Restaurant;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
@Path(value = "/ranking")
public class RankingController {

	private Result result;
	private RestaurantDAO dao;
	
	@Deprecated
	public RankingController() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	public RankingController(Result result, RestaurantDAO dao){
		this.result = result;
		this.dao = dao;
	}
	
	@Get
	@Path(value={"/",""})
	public void ranking(){
		List<Restaurant> ranking = dao.ranking();
		
		result.include("ranking",ranking);
	}
	
}
