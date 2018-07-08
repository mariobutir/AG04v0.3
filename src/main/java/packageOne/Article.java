package packageOne;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Date vrijemeUnosa;
    private Long idKorisnika;
    private String naslov;
    private String url;
    private String autor;

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
		return brojGlasova;
	}

	public void setBrojGlasova(int brojGlasova) {
		this.brojGlasova = brojGlasova;
	}

	private int brojGlasova;

    protected Article() {}

    public Article(Date vrijemeUnosa, Long idKorisnika, String naslov, String url, String autor) {
        this.vrijemeUnosa = vrijemeUnosa;
        this.idKorisnika = idKorisnika;
        this.naslov = naslov;
        this.url = url;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format(
                "'%s' - '%s'",
                naslov, autor);
    }

}