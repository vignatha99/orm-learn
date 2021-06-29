package com.handson.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.handson.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	@Query("select c from Country c where c.name like %:name% order by c.name ASC")
	List<Country> findByCustomQuery(String name);

	@Query("select c from Country c where c.name like :name% order by c.name ASC")
	List<Country> findWithSingleCharacter(String name);

}