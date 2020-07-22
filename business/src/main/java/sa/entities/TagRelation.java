package sa.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Table;
import java.util.Date;

@Entity
@Table
//@Table(name="tag_relation")
public class TagRelation {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "TAG_ID")
    private String tagId;
    @Column(name = "ARTICLE_ID")
    private String articleId;
    @Column(name="DATE_CREATED")
    private Date dateCreated;

    protected TagRelation() {
    }

    public TagRelation(String id, String tagId, String articleId, Date dateCreated) {
        this.id = id;
        this.tagId = tagId;
        this.articleId = articleId;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
