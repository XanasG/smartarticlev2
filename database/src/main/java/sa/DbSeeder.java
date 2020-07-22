package sa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sa.entities.Article;
import sa.entities.Source;
import sa.entities.Tag;
import sa.entities.TagRelation;
import sa.enums.LanguageEnum;
import sa.enums.Topic;
import sa.jpa.ArticleRepository;
import sa.jpa.SourceRepository;
import sa.services.ArticleService;
import sa.services.SourceService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

//import sa.jpa.TagRelationRepository;
//import sa.jpa.TagRepository;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private SourceService sourceService;
    /*@Autowired
    private TagRelationRepository tagRelationRepository;
    @Autowired
    private TagRepository tagRepository;*/

    private List<String> tagList = new ArrayList<>(Arrays.asList(
             "Trump", "Global Warming", "Elton Jon", "Pizza", "2020", "Mathematicians", "Innovation", "ISIS", "Oranges",
            "Alphabeat", "3D-printers", "Computers", "AMD", "Intel"
    ));

    @Autowired
    //public DbSeeder(ArticleRepository articleRepository, SourceRepository sourceRepository, TagRelationRepository tagRelationRepository, TagRepository tagRepository) {
    public DbSeeder() {
        //this.articleRepository = articleRepository;
        //this.sourceRepository = sourceRepository;
        //this.tagRelationRepository = tagRelationRepository;
        //this.tagRepository = tagRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Source tv2 = genSource("TV2News");

        List<Tag> tags = tagList.stream().map(this::genTag).collect(Collectors.toList());
        List<Article> articles = new ArrayList<>();
        List<TagRelation> tagRelList = new ArrayList<>();
        for(int i=0; i<20; i++) {
            // Init
            int diceThrow = ThreadLocalRandom.current().nextInt(0, 5);
            Topic topic = Topic.values()[diceThrow];
            int tagIndex = ThreadLocalRandom.current().nextInt(0, tagList.size()-1);
            Tag tag = tags.get(tagIndex);
            // Article
            Article article = generateArticle(tv2, topic, LanguageEnum.DK);
            articles.add(article);
            // Tag Article Relation
            TagRelation tagRelation = genTagRelation(article.getId(), tag.getId());
            tagRelList.add(tagRelation);
        }

        tv2.setArticles(articles);

        try {
            sourceService.addSource(tv2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }




    private Tag genTag(String name) {
        return new Tag(
                UUID.randomUUID().toString(),
                name,
                new java.sql.Date(System.currentTimeMillis())
        );
    }

    private TagRelation genTagRelation(String sourceId, String tagId) {
        return new TagRelation(
                UUID.randomUUID().toString(),
                sourceId,
                tagId,
                new java.sql.Date(System.currentTimeMillis())
        );
    }

    private Article generateArticle(Source source, Topic topic, LanguageEnum languageEnum) {
        return new Article(
                UUID.randomUUID().toString(),
                new java.sql.Date(System.currentTimeMillis()), // release date
                source, // SourceId
                UUID.randomUUID().toString(), // ContentId
                topic.name(),
                UUID.randomUUID().toString(), // AuthorId
                languageEnum.name(),
                new java.sql.Date(System.currentTimeMillis())
        );
    }

    private Source genSource(String name) {
        return new Source(
                UUID.randomUUID().toString(),
                name,
                LanguageEnum.DK.toString(),
                "Denmark",
                "ACTIVE",
                new java.sql.Date(System.currentTimeMillis()),
                new java.sql.Date(System.currentTimeMillis())
        );
    }
}
