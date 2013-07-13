package com.nois.pizza.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nois.pizza.model.Pizza;

@Path("/")
@Stateless
@LocalBean
@SuppressWarnings("unchecked")
public class SelfService {
	@PersistenceContext(unitName = "PizzaEjb")
	private EntityManager dao;

	@GET
	@Path("version")
	@Produces(MediaType.TEXT_PLAIN)
	public String version() {
		return "Pizza Service 1.0 - Test";
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_XML+";charset=UTF-8")
	public List<Pizza> getAll() {
		List<Pizza> data = (List<Pizza>) dao.createNamedQuery("allPizza")
				.getResultList();
		return data;
	}

	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_XML+";charset=UTF-8")
	public String size() {
		return "<registro><count>"+((Long)dao.createNamedQuery("count").getSingleResult()).intValue()+"</count></registro>";
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML+";charset=UTF-8")
	public Pizza getById(@PathParam("id") int id) {
		return dao.find(Pizza.class, id);
	}
}
