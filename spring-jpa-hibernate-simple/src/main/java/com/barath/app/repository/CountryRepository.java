package com.barath.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.barath.app.entities.Country;
import com.barath.app.entities.Player;


@Repository
public class CountryRepository {
	
	private static final Logger logger=LoggerFactory.getLogger(CountryRepository.class);
	
	@PersistenceContext(unitName="competition")
	private EntityManager entityManager;
	
	@Transactional
	public void persistCountry(Country country){
		if(logger.isInfoEnabled()){
			logger.info("Persisting the country  entity  "+country.toString());
		}
		entityManager.persist(country);
	}
	
	
	@Transactional(readOnly=true)
	public Country readCountry(long countryId){
		Country country=null;
		if(logger.isInfoEnabled()){
			logger.info("Finding the country with  ID  "+countryId);
		}
		country=entityManager.find(Country.class,countryId);
		
		return country;
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public Country updateCountry(long countryId){
		Country country=null;
		if(logger.isInfoEnabled()){
			logger.info("Finding the country with  ID  "+countryId);
		}
		country=entityManager.find(Country.class,countryId);
		
		return country;
	}
	
	@Transactional(readOnly=true)
	public void deleteCountry(long countryId){
		Country country=null;
		if(logger.isInfoEnabled()){
			logger.info("Finding the country with  ID  "+countryId);
		}
		country=entityManager.find(Country.class,countryId);
		if(country !=null){
			entityManager.remove(country);
		}
		
	}

}
