package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the predmet database table.
 * 
 */
@Entity
@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPredmet;

	private String naziv;

	//bi-directional many-to-one association to Anketa
	@OneToMany(mappedBy="predmet")
	private List<Anketa> anketas;

	//bi-directional many-to-one association to Materijal
	@OneToMany(mappedBy="predmet")
	private List<Materijal> materijals;

	//bi-directional many-to-one association to Predmetkorisnik
	@OneToMany(mappedBy="predmet")
	private List<Predmetkorisnik> predmetkorisniks;

	//bi-directional many-to-one association to Zadatak
	@OneToMany(mappedBy="predmet")
	private List<Zadatak> zadataks;

	public Predmet() {
	}

	public int getIdPredmet() {
		return this.idPredmet;
	}

	public void setIdPredmet(int idPredmet) {
		this.idPredmet = idPredmet;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Anketa> getAnketas() {
		return this.anketas;
	}

	public void setAnketas(List<Anketa> anketas) {
		this.anketas = anketas;
	}

	public Anketa addAnketa(Anketa anketa) {
		getAnketas().add(anketa);
		anketa.setPredmet(this);

		return anketa;
	}

	public Anketa removeAnketa(Anketa anketa) {
		getAnketas().remove(anketa);
		anketa.setPredmet(null);

		return anketa;
	}

	public List<Materijal> getMaterijals() {
		return this.materijals;
	}

	public void setMaterijals(List<Materijal> materijals) {
		this.materijals = materijals;
	}

	public Materijal addMaterijal(Materijal materijal) {
		getMaterijals().add(materijal);
		materijal.setPredmet(this);

		return materijal;
	}

	public Materijal removeMaterijal(Materijal materijal) {
		getMaterijals().remove(materijal);
		materijal.setPredmet(null);

		return materijal;
	}

	public List<Predmetkorisnik> getPredmetkorisniks() {
		return this.predmetkorisniks;
	}

	public void setPredmetkorisniks(List<Predmetkorisnik> predmetkorisniks) {
		this.predmetkorisniks = predmetkorisniks;
	}

	public Predmetkorisnik addPredmetkorisnik(Predmetkorisnik predmetkorisnik) {
		getPredmetkorisniks().add(predmetkorisnik);
		predmetkorisnik.setPredmet(this);

		return predmetkorisnik;
	}

	public Predmetkorisnik removePredmetkorisnik(Predmetkorisnik predmetkorisnik) {
		getPredmetkorisniks().remove(predmetkorisnik);
		predmetkorisnik.setPredmet(null);

		return predmetkorisnik;
	}

	public List<Zadatak> getZadataks() {
		return this.zadataks;
	}

	public void setZadataks(List<Zadatak> zadataks) {
		this.zadataks = zadataks;
	}

	public Zadatak addZadatak(Zadatak zadatak) {
		getZadataks().add(zadatak);
		zadatak.setPredmet(this);

		return zadatak;
	}

	public Zadatak removeZadatak(Zadatak zadatak) {
		getZadataks().remove(zadatak);
		zadatak.setPredmet(null);

		return zadatak;
	}

}