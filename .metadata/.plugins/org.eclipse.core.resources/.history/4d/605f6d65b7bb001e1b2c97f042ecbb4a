package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the materijal database table.
 * 
 */
@Entity
@NamedQuery(name="Materijal.findAll", query="SELECT m FROM Materijal m")
public class Materijal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaterijal;

	private String naziv;

	private String sadrzaj;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	private Predmet predmet;

	public Materijal() {
	}

	public int getIdMaterijal() {
		return this.idMaterijal;
	}

	public void setIdMaterijal(int idMaterijal) {
		this.idMaterijal = idMaterijal;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
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

}