package com.mudl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Uloga;

public interface UlogaRepository extends JpaRepository<Uloga, Integer> {
	
	Uloga getByNaziv(String naziv);

}
