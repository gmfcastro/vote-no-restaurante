package com.bluesoft.vote.no.restaurante.controller;

import javax.inject.Inject;

import com.bluesoft.vote.no.restaurante.model.dao.UserDAO;
import com.bluesoft.vote.no.restaurante.model.entities.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Path(value="/user")
@Controller
public class UserController {

	private Result result;
	private UserDAO dao;
	
	/**
     * CDI eyes only
     * @deprecated
     */
	public UserController(){
		
	}
	
	@Inject
	public UserController(Result result, UserDAO dao){
		this.result = result;
		this.dao = dao;
	}
	
	@Get
	@Path(value = {"","/"})
	public void index(){
		
	}
	
	@Post
	@Path(value = "/create")
	public void create(User user){
		
		if(userExists(user)){
			User u = new User();
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			
			dao.save(u);
			result.include("success","User created!");
		}else{
			result.include("success","User registred!");
		}
		
		result.redirectTo(RankingController.class).ranking();
	}
	
	private boolean userExists(User user){
		User u = dao.findByEmail(user.getEmail());
		
		return u!=null ? true : false;
	}
	
}
