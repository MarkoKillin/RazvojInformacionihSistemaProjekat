package com.mudl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Anketa;

public interface AnketaRepository extends JpaRepository<Anketa, Integer>{

	@Query("select a from Anketa a where a.predmet.idPredmet = :idP")
	List<Anketa> getAnketeZaPredmet(@Param("idP") int idPredmet);

}
