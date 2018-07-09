package packageOne;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private Date vrijemeUnosa;
    @Column
    private Long idKorisnika;
    @Column
    private String naslov;
    @Column
    private String url;
    @Column
    private String autor;
    @Column
    private int brojGlasova;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVrijemeUnosa() {
		return vrijemeUnosa;
	}
	
	public void setVrijemeUnosa(Date vrijemeUnosa) {
		this.vrijemeUnosa = vrijemeUnosa;
	}

	public Long getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(Long idKorisnika) {
		this.idKorisnika = idKorisnika;
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
	
	public int getBrojGlasova() {
		return this.brojGlasova;
	}
	
	public void setBrojGlasova(int broj) {
		this.brojGlasova = broj;
	}

    protected Article() {}

    public Article(Date vrijemeUnosa, Long idKorisnika, String naslov, String url, String autor, int brojGlasova) {
        this.vrijemeUnosa = vrijemeUnosa;
        this.idKorisnika = idKorisnika;
        this.naslov = naslov;
        this.url = url;
        this.autor = autor;
        this.brojGlasova = brojGlasova;
    }

    @Override
    public String toString() {
        return naslov + " - " + autor;
    }

}