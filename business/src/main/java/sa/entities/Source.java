package sa.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Source implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String language;
    private String country;
    private String status;
    @Column(name = "DATE_CREATED")
    private Date dateCreated;
    @Column(name = "DATE_INACTIVE")
    private Date dateInactive;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    private List<Article> articles;

    protected Source() {
    }

    public Source(String id, String name, String language, String country, String status, Date dateCreated, Date dateInactive) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.country = country;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateInactive = dateInactive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateInactive() {
        return dateInactive;
    }

    public void setDateInactive(Date dateInactive) {
        this.dateInactive = dateInactive;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
