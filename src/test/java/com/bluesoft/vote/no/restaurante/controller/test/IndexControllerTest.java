package com.bluesoft.vote.no.restaurante.controller.test;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bluesoft.vote.no.restaurante.controller.IndexController;
import com.bluesoft.vote.no.restaurante.model.dao.RestaurantDAO;
import com.bluesoft.vote.no.restaurante.model.entities.Restaurant;

import br.com.caelum.vraptor.util.test.MockSerializationResult;

@RunWith(MockitoJUnitRunner.class)
public class IndexControllerTest {

	private MockSerializationResult result;
    private RestaurantDAO dao;
    private IndexController controller;
    
    @Mock
    private static EntityManager entityManager;
    @Mock
    private static Query query;
	
    @Before
    public void setUp() {
        result = new MockSerializationResult();
        dao = mock(RestaurantDAO.class);
        controller = new IndexController(result, dao);
    }
    
	@Test
	public void shouldInsertData() {
		
		List<Restaurant> rl = new ArrayList<Restaurant>();
		
		given(dao.list()).willReturn(rl);
		
		Assert.assertTrue(rl.isEmpty());
		
		controller.index();
		
		Restaurant r = mock(Restaurant.class);
		rl.add(r);
		
		r = mock(Restaurant.class);
		rl.add(r);
		
		r = mock(Restaurant.class);
		rl.add(r);
		
		r = mock(Restaurant.class);
		rl.add(r);
		
		r = mock(Restaurant.class);
		rl.add(r);
		
		given(dao.list()).willReturn(rl);
		
		Assert.assertTrue(dao.list().size() == 5);		
	}

	@Test
	public void shouldLoadRestaurantesJSON(){
		List<Restaurant> rl = new ArrayList<>();
		
		Restaurant r = new Restaurant("McDonalds");
		r.setId(1l);
		rl.add(r);
		
		r = new Restaurant("Burger King");
		r.setId(2l);
		rl.add(r);
		
		r = new Restaurant("Outback");
		r.setId(3l);
		rl.add(r);
		
		r = new Restaurant("Bobs");
		r.setId(4l);
		rl.add(r);
		
		r = new Restaurant("Subway");
		r.setId(5l);
		rl.add(r);
		
		given(dao.list()).willReturn(rl);
		
		controller.restaurantes();
		
		try {
			Assert.assertEquals("[{\"name\":\"McDonalds\",\"votes\":0,\"id\":1,\"active\":true},{\"name\":\"Burger King\",\"votes\":0,\"id\":2,\"active\":true},{\"name\":\"Outback\",\"votes\":0,\"id\":3,\"active\":true},{\"name\":\"Bobs\",\"votes\":0,\"id\":4,\"active\":true},{\"name\":\"Subway\",\"votes\":0,\"id\":5,\"active\":true}]", result.serializedResult());
		} catch (Exception e) {
			Assert.fail();
		}
		
	}

	@Test
	public void testVote() {
		
		controller.index();
		
		Restaurant r = new Restaurant();
		r.setId(1l);
		r.setVotes(0);
		r.setName("Teste");
		
		int votes = r.getVotes();
		
		given(dao.findById(r.getId())).willReturn(r);
		given(dao.update(r)).willReturn(r);
		
		r = controller.vote(r);
		
		Assert.assertEquals(votes+1, r.getVotes());
	}

}
