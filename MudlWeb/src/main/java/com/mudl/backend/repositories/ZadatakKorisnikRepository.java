package com.mudl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Zadatakkorisnik;

public interface ZadatakKorisnikRepository extends JpaRepository<Zadatakkorisnik, Integer>{

	@Query("select zk from Zadatakkorisnik zk where zk.zadatak.predmet.idPredmet = :idP")
	List<Zadatakkorisnik> getResenja(@Param("idP") int idPredmet);

}
