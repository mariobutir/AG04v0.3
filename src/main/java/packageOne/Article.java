package packageOne;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Date vrijemeUnosa;
    private Long idKorisnika;
    private String naslov;
    private String url;
    private String autor;
    private Long brojGlasova;

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

	public long getBrojGlasova() {
		return brojGlasova;
	}

	public void setBrojGlasova(long brojGlasova) {
		this.brojGlasova = brojGlasova;
	}

    protected Article() {}

    public Article(Date vrijemeUnosa, Long idKorisnika, String naslov, String url, String autor, long brojGlasova) {
        this.vrijemeUnosa = vrijemeUnosa;
        this.idKorisnika = idKorisnika;
        this.naslov = naslov;
        this.url = url;
        this.autor = autor;
        this.brojGlasova = brojGlasova;
    }

    @Override
    public String toString() {
        return String.format(
                "'%s' - '%s'",
                naslov, autor);
    }

}