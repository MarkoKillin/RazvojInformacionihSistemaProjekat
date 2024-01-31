package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Izborkorisnik
	@OneToMany(mappedBy="korisnik")
	private List<Izborkorisnik> izborkorisniks;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	//bi-directional many-to-one association to Predmetkorisnik
	@OneToMany(mappedBy="korisnik")
	private List<Predmetkorisnik> predmetkorisniks;

	//bi-directional many-to-one association to Zadatakkorisnik
	@OneToMany(mappedBy="korisnik")
	private List<Zadatakkorisnik> zadatakkorisniks;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Izborkorisnik> getIzborkorisniks() {
		return this.izborkorisniks;
	}

	public void setIzborkorisniks(List<Izborkorisnik> izborkorisniks) {
		this.izborkorisniks = izborkorisniks;
	}

	public Izborkorisnik addIzborkorisnik(Izborkorisnik izborkorisnik) {
		getIzborkorisniks().add(izborkorisnik);
		izborkorisnik.setKorisnik(this);

		return izborkorisnik;
	}

	public Izborkorisnik removeIzborkorisnik(Izborkorisnik izborkorisnik) {
		getIzborkorisniks().remove(izborkorisnik);
		izborkorisnik.setKorisnik(null);

		return izborkorisnik;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Predmetkorisnik> getPredmetkorisniks() {
		return this.predmetkorisniks;
	}

	public void setPredmetkorisniks(List<Predmetkorisnik> predmetkorisniks) {
		this.predmetkorisniks = predmetkorisniks;
	}

	public Predmetkorisnik addPredmetkorisnik(Predmetkorisnik predmetkorisnik) {
		getPredmetkorisniks().add(predmetkorisnik);
		predmetkorisnik.setKorisnik(this);

		return predmetkorisnik;
	}

	public Predmetkorisnik removePredmetkorisnik(Predmetkorisnik predmetkorisnik) {
		getPredmetkorisniks().remove(predmetkorisnik);
		predmetkorisnik.setKorisnik(null);

		return predmetkorisnik;
	}

	public List<Zadatakkorisnik> getZadatakkorisniks() {
		return this.zadatakkorisniks;
	}

	public void setZadatakkorisniks(List<Zadatakkorisnik> zadatakkorisniks) {
		this.zadatakkorisniks = zadatakkorisniks;
	}

	public Zadatakkorisnik addZadatakkorisnik(Zadatakkorisnik zadatakkorisnik) {
		getZadatakkorisniks().add(zadatakkorisnik);
		zadatakkorisnik.setKorisnik(this);

		return zadatakkorisnik;
	}

	public Zadatakkorisnik removeZadatakkorisnik(Zadatakkorisnik zadatakkorisnik) {
		getZadatakkorisniks().remove(zadatakkorisnik);
		zadatakkorisnik.setKorisnik(null);

		return zadatakkorisnik;
	}

}