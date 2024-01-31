package com.mudl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Integer>{

	@Query("select p from Predmet p, Predmetkorisnik pk "
			+ "where pk.korisnik.username = :u and pk.predmet.idPredmet = p.idPredmet")
	List<Predmet> getPredmetForUsername(@Param("u") String username);

	@Query("select p from Predmet p "
			+ "where p not in (select pka.predmet from Predmetkorisnik pka where pka.korisnik.username = :username)")
	List<Predmet> getPredmetForJoin(@Param("username") String username);


	

}
