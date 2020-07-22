package sa.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(generator="uuid") // @GeneratedValue(generator="uuid", strategy=GenerationType.SEQUENCE)
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    private String language;
    @Column(name="RELEASE_DATE")
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="source_id")
    private Source source;

    @Column(name="CONTENT_ID")
    private String contentId;
    private String topic;
    @Column(name="AUTHOR_ID")
    private String authorId;
    @Column(name="DATE_CREATED")
    private Date dateCreated;


    Article(){}

    public Article(String id, Date releaseDate, Source source, String contentId, String topic, String authorId, String language, Date dateCreated) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.source = source;
        this.contentId = contentId;
        this.topic = topic;
        this.authorId = authorId;
        this.language = language;
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

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
