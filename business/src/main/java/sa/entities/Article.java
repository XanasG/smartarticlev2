package sa.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(generator="uuid") // @GeneratedValue(generator="uuid", strategy=GenerationType.SEQUENCE)
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    private String language;
    @Column(name="RELEASE_DATE")
    private Date releaseDate;
    @Column(name="SOURCE_ID")
    private String sourceId;
    @Column(name="CONTENT_ID")
    private String contentId;
    @Column(name="NEWS_TAG")
    private String newsTag;
    @Column(name="AUTHOR_ID")
    private String authorId;
    @Column(name="DATE_CREATED")
    private Date dateCreated;

    protected Article(){}

    public Article(String id, String language, Date releaseDate, String sourceId, String contentId, String newsTag, String authorId, Date dateCreated) {
        this.id = id;
        this.language = language;
        this.releaseDate = releaseDate;
        this.sourceId = sourceId;
        this.contentId = contentId;
        this.newsTag = newsTag;
        this.authorId = authorId;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getNewsTag() {
        return newsTag;
    }

    public void setNewsTag(String newsTag) {
        this.newsTag = newsTag;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
