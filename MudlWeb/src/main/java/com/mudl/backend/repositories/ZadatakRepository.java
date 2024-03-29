package com.mudl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Zadatak;

public interface ZadatakRepository extends JpaRepository<Zadatak, Integer>{

	@Query("select z from Zadatak z where z.predmet.idPredmet = :idP")
	List<Zadatak> getZadaciSaPredmeta(@Param("idP") int idPredmet);

}
