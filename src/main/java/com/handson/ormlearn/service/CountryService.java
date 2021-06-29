package com.handson.ormlearn.service;

import java.util.List;

import com.handson.ormlearn.model.Country;
import com.handson.ormlearn.service.exception.CountryNotFoundException;

public interface CountryService {

	public List<Country> getAllCountries();

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	public void addCountry(Country country);


	void deleteCountry(String code);
	
	List<Country> findCountryByCharacter(String name);

	List<Country> findCountryUsingSingleCharacter(String name);

	
}