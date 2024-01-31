package com.mudl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Materijal;

public interface MaterijalRepository extends JpaRepository<Materijal, Integer>{

	@Query("select m from Materijal m where m.predmet.idPredmet = :idP")
	List<Materijal> getMaterijalSaPredmeta(@Param("idP") int idPredmet);

}
