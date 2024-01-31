package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the zadatak database table.
 * 
 */
@Entity
@NamedQuery(name="Zadatak.findAll", query="SELECT z FROM Zadatak z")
public class Zadatak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZadatak;

	private String naziv;

	@Temporal(TemporalType.DATE)
	private Date rokZaPredaju;

	private String sadrzaj;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	private Predmet predmet;

	//bi-directional many-to-one association to Zadatakkorisnik
	@OneToMany(mappedBy="zadatak")
	private List<Zadatakkorisnik> zadatakkorisniks;

	public Zadatak() {
	}

	public int getIdZadatak() {
		return this.idZadatak;
	}

	public void setIdZadatak(int idZadatak) {
		this.idZadatak = idZadatak;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getRokZaPredaju() {
		return this.rokZaPredaju;
	}

	public void setRokZaPredaju(Date rokZaPredaju) {
		this.rokZaPredaju = rokZaPredaju;
	}

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public List<Zadatakkorisnik> getZadatakkorisniks() {
		return this.zadatakkorisniks;
	}

	public void setZadatakkorisniks(List<Zadatakkorisnik> zadatakkorisniks) {
		this.zadatakkorisniks = zadatakkorisniks;
	}

	public Zadatakkorisnik addZadatakkorisnik(Zadatakkorisnik zadatakkorisnik) {
		getZadatakkorisniks().add(zadatakkorisnik);
		zadatakkorisnik.setZadatak(this);

		return zadatakkorisnik;
	}

	public Zadatakkorisnik removeZadatakkorisnik(Zadatakkorisnik zadatakkorisnik) {
		getZadatakkorisniks().remove(zadatakkorisnik);
		zadatakkorisnik.setZadatak(null);

		return zadatakkorisnik;
	}

}