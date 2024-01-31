package com.mudl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Izbor;
import model.Korisnik;

public interface IzborRepository extends JpaRepository<Izbor, Integer>{

	@Query("select i from Izbor i where i.anketa.idAnketa = :idA")
	List<Izbor> getIzborAnketa(@Param("idA") int idAnketa);

	@Query("select ik.korisnik from Izborkorisnik ik where ik.izbor = :i")
	List<Korisnik> getKorisniciZaIzbor(@Param("i") Izbor izbor);

}
