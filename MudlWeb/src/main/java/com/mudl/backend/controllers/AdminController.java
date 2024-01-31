package com.mudl.backend.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mudl.backend.exceptions.InvalidMethodParameterException;
import com.mudl.backend.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Marko Mirkovic
 * 
 *         https://github.com/MarkoKillin
 * 
 *         Purpose of this controller is to handle requests for "admin" role
 */

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	@GetMapping("getAddPredmet")
	public String getAddPredmet() {
		return "dodavanje_predmeta";
	}

	@PostMapping("addPredmet")
	public String addPredmet(HttpServletRequest req, @RequestParam("naziv") String naziv) {
		int newId = as.savePredmet(naziv);
		if (newId == -1)
			req.setAttribute("message", "Doslo je do greske prilikom cuvanja.");
		else
			req.setAttribute("message", "Uspesno cuvanje. Id predmeta je: " + newId);
		return "home";
	}
	
	@GetMapping("getAddProfesorForPredmet")
	public String getAddProfesorForPredmet(HttpServletRequest req) {
		req.setAttribute("listaPredmeta", as.getPredmets());
		req.setAttribute("listaProfesora", as.getProfesors());
		return "dodavanje_profesora_predmetu";
	}
	
	@PostMapping("addProfesorForPredmet")
	public String addProfesorForPredmet(HttpServletRequest req, @RequestParam("idPredmet") int idPredmet, 
			@RequestParam("idKorisnik") int idKorisnik) {
		int newId = as.saveProfesor(idPredmet, idKorisnik);
		if (newId == -1)
			req.setAttribute("message", "Doslo je do greske prilikom cuvanja.");
		else
			req.setAttribute("message", "Uspesno cuvanje. Id predmetkorisnik-a je: " + newId);
		return "home";
	}
	
	@GetMapping("getAddKorisnik")
	public String getAddKorisnik(HttpServletRequest req) {
		req.setAttribute("listaUloga", as.getUloga());
		return "dodavanje_korisnika";
	}
	
	@PostMapping("addKorisnik")
	public String addKorisnik(HttpServletRequest req, @RequestParam("ime") String ime, @RequestParam("prezime") String prezime,
			@RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("idUloga") int idUloga) {
		int newId = -1;
		try {
			newId = as.saveKorisnik(ime, prezime, email, username, password, idUloga);
			if (newId == -1)
				req.setAttribute("message", "Doslo je do greske prilikom cuvanja.");
			else
				req.setAttribute("message", "Uspesno cuvanje. Id korisnika je: " + newId);
		} catch (InvalidMethodParameterException e) {
			req.setAttribute("message", e.getMessage());
		}
		return "home";
	}
	
	@GetMapping("getClearPredmet")
	public String getClearPredmet(HttpServletRequest req) {
		req.setAttribute("listaPredmeta", as.getPredmets());
		return "obrisi_studente_sa_predmeta";
	}
	
	@PostMapping("clearPredmet")
	public String clearPredmet(HttpServletRequest req, @RequestParam("idPredmet") int idPredmet) {
		int res = as.clearPredmet(idPredmet);
		if (res == -1)
			req.setAttribute("message", "Doslo je do greske prilikom brisanja.");
		else
			req.setAttribute("message", "Uspesno je obrisano " + res + " studenata sa predmeta.");
		return "home";
	}
	
	@GetMapping("getUpdateProfile")
	public String getUpdateProfile(HttpServletRequest req, Principal p) {
		req.setAttribute("profil", as.getKorisnikByUsername(p.getName()));
		return "uredi_profil";
	}
	
	@PostMapping("updateProfile")
	public String updateProfile(HttpServletRequest req, @RequestParam("ime") String ime, @RequestParam("prezime") String prezime,
			@RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("npassword") String npassword, Principal p) {
		int id = -1;
		try {
			id = as.updateProfile(ime, prezime, email, username, password, npassword, p);
			if (id == -1)
				req.setAttribute("message", "Došlo je do greške prilikom čuvanja.");
			else
				req.setAttribute("message", "Uspešno čuvanje. Id korisnika je: " + id);
		} catch (InvalidMethodParameterException e) {
			req.setAttribute("message", e.getMessage());
		}
		return "home";
	}

	@GetMapping("home")
	public String getHomePage() {
		return "home";
	}
}
