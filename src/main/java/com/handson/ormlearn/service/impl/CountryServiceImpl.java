package com.handson.ormlearn.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.ormlearn.model.Country;
import com.handson.ormlearn.repository.CountryRepository;
import com.handson.ormlearn.service.CountryService;
import com.handson.ormlearn.service.exception.CountryNotFoundException;

@Transactional
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Override
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}
		return result.get();
	}



	@Override
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);		
	}
	
	@Override
	public List<Country> findCountryByCharacter(String name) {

		return countryRepository.findByCustomQuery(name);
	}

	@Override
	public List<Country> findCountryUsingSingleCharacter(String name) {

		return countryRepository.findWithSingleCharacter(name);
	}

	

}
