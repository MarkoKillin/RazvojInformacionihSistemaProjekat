package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the zadatakkorisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Zadatakkorisnik.findAll", query="SELECT z FROM Zadatakkorisnik z")
public class Zadatakkorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZadatakKorisnik;

	private byte[] file;

	private String fileName;

	private String sadrzaj;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Zadatak
	@ManyToOne
	private Zadatak zadatak;

	public Zadatakkorisnik() {
	}

	public int getIdZadatakKorisnik() {
		return this.idZadatakKorisnik;
	}

	public void setIdZadatakKorisnik(int idZadatakKorisnik) {
		this.idZadatakKorisnik = idZadatakKorisnik;
	}

	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Zadatak getZadatak() {
		return this.zadatak;
	}

	public void setZadatak(Zadatak zadatak) {
		this.zadatak = zadatak;
	}

}