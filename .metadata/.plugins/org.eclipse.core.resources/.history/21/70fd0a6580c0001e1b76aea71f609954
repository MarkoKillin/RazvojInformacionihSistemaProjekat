package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the izborkorisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Izborkorisnik.findAll", query="SELECT i FROM Izborkorisnik i")
public class Izborkorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIzborKorisnik;

	//bi-directional many-to-one association to Izbor
	@ManyToOne
	private Izbor izbor;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Izborkorisnik() {
	}

	public int getIdIzborKorisnik() {
		return this.idIzborKorisnik;
	}

	public void setIdIzborKorisnik(int idIzborKorisnik) {
		this.idIzborKorisnik = idIzborKorisnik;
	}

	public Izbor getIzbor() {
		return this.izbor;
	}

	public void setIzbor(Izbor izbor) {
		this.izbor = izbor;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}