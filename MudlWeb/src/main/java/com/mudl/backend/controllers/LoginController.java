package com.mudl.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String getLoginPage() {
		//generateBasicUsers();
		return "login";
	}
	
	/*
	@Autowired
	PasswordEncoder pe;
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	UlogaRepository ur;
	
	
	public void generateBasicUsers() {
		Korisnik admin = new Korisnik();
		admin.setIme("Marko");
		admin.setPrezime("Mirkovic");
		admin.setEmail("mpty");
		admin.setUsername("admin");
		admin.setPassword(pe.encode("admin"));
		admin.setUloga(ur.findById(1).get());
		kr.save(admin);
		
		Korisnik profesor = new Korisnik();
		profesor.setIme("Bogdan");
		profesor.setPrezime("Markovic");
		profesor.setEmail("mpty");
		profesor.setUsername("profesor");
		profesor.setPassword(pe.encode("profesor"));
		profesor.setUloga(ur.findById(2).get());
		kr.save(profesor);
		
		
		Korisnik student = new Korisnik();
		student.setIme("Bogdana");
		student.setPrezime("Marovic");
		student.setEmail("mpty");
		student.setUsername("student");
		student.setPassword(pe.encode("student"));
		student.setUloga(ur.findById(3).get());
		kr.save(student);
	}
	*/
}
