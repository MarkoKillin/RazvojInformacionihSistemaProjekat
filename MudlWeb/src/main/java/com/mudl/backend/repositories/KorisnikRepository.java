package com.mudl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{

	Korisnik findByUsername(String username);

	@Query("select k from Korisnik k where k.username = :name and k.uloga.naziv = 'Profesor'")
	Korisnik getProfesorByName(@Param("name") String name);

	@Query("select k from Korisnik k, Predmetkorisnik pk "
			+ "where pk.predmet.idPredmet = :idP and pk.korisnik.uloga.naziv = 'Student' and pk.korisnik.idKorisnik = k.idKorisnik order by k.prezime")
	List<Korisnik> getStudentForPredmet(@Param("idP") int idPredmet);

	@Query("select k from Korisnik k where k.username = :name and k.uloga.naziv = 'Student'")
	Korisnik getStudentByName(@Param("name") String name);

	@Query("select k from Korisnik k where k.uloga.naziv = 'Profesor'")
	List<Korisnik> getProfesors();

}