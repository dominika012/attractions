package com.ibm.itacademy.attractions.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Param;
import org.omnifaces.cdi.ViewScoped;

import com.ibm.itacademy.attractions.Attraction;
import com.ibm.itacademy.attractions.AttractionDao;
import com.ibm.itacademy.attractions.Trail;
import com.ibm.itacademy.attractions.TrailDao;
import com.ibm.itacademy.attractions.JpaTrailService;


@Named
@ViewScoped
public class TrailsBean implements Serializable {
	@Inject
	private TrailDao trailDao;
	
	private List<Trail> trails = new LinkedList<Trail>();
	
	private Trail trail;
	
	private String query;
	
	
	@PostConstruct
	public void init() {
		trails = trailDao.list();
		trail = new Trail();
	}
	
	
	public void delete(Trail trail) {
		trailDao.delete(trail);
		init();
	}
	
	public void submit() {
		trailDao.saveOrUpdate(trail);
		init();
	}

	
	public List<Trail> getTrails() {
		return trails;
	}

	public void setTrails(List<Trail> trails) {
		this.trails = trails;
	}

	public Trail getTrail() {
		return trail;
	}

	public void setTrail(Trail trail) {
		this.trail = trail;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
	
	
}
