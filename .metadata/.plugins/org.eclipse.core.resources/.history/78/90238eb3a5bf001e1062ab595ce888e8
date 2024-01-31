package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the izbor database table.
 * 
 */
@Entity
@NamedQuery(name="Izbor.findAll", query="SELECT i FROM Izbor i")
public class Izbor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIzbor;

	private String naziv;

	//bi-directional many-to-one association to Anketa
	@ManyToOne
	private Anketa anketa;

	//bi-directional many-to-one association to Izborkorisnik
	@OneToMany(mappedBy="izbor")
	private List<Izborkorisnik> izborkorisniks;

	public Izbor() {
	}

	public int getIdIzbor() {
		return this.idIzbor;
	}

	public void setIdIzbor(int idIzbor) {
		this.idIzbor = idIzbor;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Anketa getAnketa() {
		return this.anketa;
	}

	public void setAnketa(Anketa anketa) {
		this.anketa = anketa;
	}

	public List<Izborkorisnik> getIzborkorisniks() {
		return this.izborkorisniks;
	}

	public void setIzborkorisniks(List<Izborkorisnik> izborkorisniks) {
		this.izborkorisniks = izborkorisniks;
	}

	public Izborkorisnik addIzborkorisnik(Izborkorisnik izborkorisnik) {
		getIzborkorisniks().add(izborkorisnik);
		izborkorisnik.setIzbor(this);

		return izborkorisnik;
	}

	public Izborkorisnik removeIzborkorisnik(Izborkorisnik izborkorisnik) {
		getIzborkorisniks().remove(izborkorisnik);
		izborkorisnik.setIzbor(null);

		return izborkorisnik;
	}

}