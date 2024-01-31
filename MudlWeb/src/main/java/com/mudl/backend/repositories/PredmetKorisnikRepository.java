package com.mudl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import model.Predmetkorisnik;

public interface PredmetKorisnikRepository extends JpaRepository<Predmetkorisnik, Integer>{

	@Query("select pk from Predmetkorisnik pk "
			+ "where pk.predmet.idPredmet = :idP and pk.korisnik.idKorisnik = :idS")
	Predmetkorisnik getPredmetkorisnik(@Param("idS") int idStudent,@Param("idP") int idPredmet);

	@Modifying
	@Transactional
	@Query("delete from Predmetkorisnik pk where pk.predmet.idPredmet = :idP and pk.korisnik.uloga.naziv = 'Student'")
	int clearPredmet(@Param("idP") int idPredmet);

}
