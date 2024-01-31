package com.mudl.backend.services;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mudl.backend.exceptions.InvalidMethodParameterException;
import com.mudl.backend.repositories.AnketaRepository;
import com.mudl.backend.repositories.IzborKorisnikRepository;
import com.mudl.backend.repositories.IzborRepository;
import com.mudl.backend.repositories.KorisnikRepository;
import com.mudl.backend.repositories.MaterijalRepository;
import com.mudl.backend.repositories.PredmetKorisnikRepository;
import com.mudl.backend.repositories.PredmetRepository;
import com.mudl.backend.repositories.ZadatakKorisnikRepository;
import com.mudl.backend.repositories.ZadatakRepository;

import model.Anketa;
import model.Izbor;
import model.Izborkorisnik;
import model.Korisnik;
import model.Materijal;
import model.Predmet;
import model.Predmetkorisnik;
import model.Zadatak;
import model.Zadatakkorisnik;

@Service
public class StudentService {
	
	@Autowired
	private KorisnikRepository kr;
	
	@Autowired
	private PredmetRepository pr;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private ZadatakRepository zr;
	
	@Autowired
	private MaterijalRepository mr;
	
	@Autowired
	private PredmetKorisnikRepository pkr;
	
	@Autowired
	private AnketaRepository ar;
	
	@Autowired
	private IzborRepository ir;
	
	@Autowired
	private IzborKorisnikRepository ikr;
	
	@Autowired
	private ZadatakKorisnikRepository zkr;

	/**
	 * Trazi korisnika(student) koji ima prosledjeno ime
	 */
	public Korisnik getStudent(String name) {
		return kr.getStudentByName(name);
	}

	/**
	 * Trazi predmete koje slusa prosledjeni student
	 */
	public List<Predmet> getPredmetForStudent(Korisnik student) {
		return pr.getPredmetForUsername(student.getUsername());
	}

	public Predmet findPredmetById(int idPredmet) {
		return pr.findById(idPredmet).get();
	}

	public Korisnik getKorisnikByUsername(String name) {
		return kr.findByUsername(name);
	}
	
	public int updateProfile(String ime, String prezime, String email, String username, String password,
			String npassword, Principal p) throws InvalidMethodParameterException {
		Korisnik k = kr.findByUsername(p.getName());
		if(!encoder.matches(password, k.getPassword()))
			throw new InvalidMethodParameterException("Uneta lozinka nije ista kao stara.");
		k.setIme(ime);
		k.setPrezime(prezime);
		k.setEmail(email);
		k.setUsername(username);
		if(!npassword.equals(""))
			k.setPassword(encoder.encode(npassword));
		Korisnik k1 = kr.save(k);
		if(k1 != null)
			return k1.getIdKorisnik();
		return -1;
	}

	public List<Zadatak> getZadatak(int idPredmet) {
		return zr.getZadaciSaPredmeta(idPredmet);
	}

	public List<Materijal> getMaterijal(int idPredmet) {
		return mr.getMaterijalSaPredmeta(idPredmet);
	}

	public List<Predmet> getPredmetForJoin(String username) {
		return pr.getPredmetForJoin(username);
	}

	public int addToPredmet(int idPredmet, String name) {
		Predmetkorisnik pk = new Predmetkorisnik();
		pk.setBrojBodova(0);
		Predmet p;
		Korisnik k = kr.getStudentByName(name);
		try {
			p = pr.findById(idPredmet).get();
		} catch (NoSuchElementException e) {
			return -1;
		}
		pk.setKorisnik(k);
		pk.setPredmet(p);
		Predmetkorisnik pk1 = pkr.save(pk);
		if (pk1 != null)
			return pk1.getIdPredmetKorisnik();
		return -1;
	}

	public List<Anketa> getAnketeSaPredmeta(int idPredmet) {
		return ar.getAnketeZaPredmet(idPredmet);
	}

	public List<Izbor> getIzboriSaAnkete(int idAnketa) {
		return ir.getIzborAnketa(idAnketa);
	}

	public Anketa getAnketaById(int idAnketa) {
		return ar.findById(idAnketa).get();
	}

	public int addIzbor(int idIzbor, String name) {
		Izborkorisnik ik = new Izborkorisnik();
		Korisnik k = kr.findByUsername(name);
		try {
			ik.setIzbor(ir.findById(idIzbor).get());
			if (k == null)
				return -1;
		} catch (NoSuchElementException e) {
			return -1;
		}
		ik.setKorisnik(k);
		Izborkorisnik ik1 = ikr.save(ik);
		if(ik1 != null)
			return ik1.getIdIzborKorisnik();
		return -1;
	}

	public int saveDomaci(MultipartFile file, int idZadatak, String sadrzaj, String username, String fileName) throws InvalidMethodParameterException, IOException{
		Zadatakkorisnik zk = new Zadatakkorisnik();
		zk.setSadrzaj(sadrzaj);
		zk.setZadatak(zr.findById(idZadatak).get());
		zk.setKorisnik(kr.findByUsername(username));
		zk.setFile(file.getBytes());
		zk.setFileName(fileName);
		
		Zadatakkorisnik zk1 = zkr.save(zk);
		if(zk1 != null)
			return zk1.getIdZadatakKorisnik();
		return -1;
	}

}
