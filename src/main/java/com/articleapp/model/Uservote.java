package com.articleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Uservote {

	@Id
	@Column
	private String userarticleid;
	@Column
	private String korisnik;
	@Column
	private String vote;

	public Uservote() {
	}

	public Uservote(String id, String korisnik, String vote) {
		this.userarticleid = id;
		this.korisnik = korisnik;
		this.vote = vote;
	}

	public String getUserarticleid() {
		return userarticleid;
	}

	public void setUserarticleid(String userarticleid) {
		this.userarticleid = userarticleid;
	}

	public String getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

}
