package com.articleapp.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;

@Entity
@Table
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private Timestamp vrijemeunosa;
	@Column
	private String korisnik;
	@Column
	@NotEmpty(message = "Molimo unesite naziv clanka.")
	private String naslov;
	@Column
	@NotBlank(message = "Uneseni link nije ispravan.")
	@URL
	private String url;
	@Column
	@NotEmpty(message = "Molimo unesite ime autora.")
	private String autor;
	@Column
	public Integer brojglasova;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.sql.Timestamp getvrijemeunosa() {
		return vrijemeunosa;
	}

	public void setvrijemeunosa(Timestamp timestamp) {
		this.vrijemeunosa = timestamp;
	}

	public String getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public long getbrojglasova() {
		return this.brojglasova;
	}

	public void setbrojglasova(Integer broj) {
		this.brojglasova = broj;
	}

	public Article() {
	}

	public Article(Timestamp vrijemeunosa, String korisnik, String naslov, String url, String autor,
			Integer brojglasova) {
		this.vrijemeunosa = vrijemeunosa;
		this.korisnik = korisnik;
		this.naslov = naslov;
		this.url = url;
		this.autor = autor;
		this.brojglasova = brojglasova;
	}

	@Override
	public String toString() {
		return naslov + " - " + autor;
	}

}