package sa.repos;

import sa.entities.Article;
import sa.enums.LanguageEnum;
import sa.enums.NewsTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DbSeeder implements CommandLineRunner {

    private ArticleRepository articleRepository;

    @Autowired
    public DbSeeder(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Article tv2news = generateArticle(NewsTag.BUSINESS, LanguageEnum.DK);
        Article dr1news = generateArticle(NewsTag.CRIME, LanguageEnum.DK);
        Article tv2nordnews = generateArticle(NewsTag.POLITICS, LanguageEnum.ENG);

        List<Article> articles = new ArrayList<>();
        articles.add(tv2news);
        articles.add(dr1news);
        articles.add(tv2nordnews);

        try {
            this.articleRepository.saveAll(articles);
        } catch (Exception ex) {
            int a = 1;
        }

    }

    private Article generateArticle(NewsTag newsTag, LanguageEnum languageEnum) {
        return new Article(
                UUID.randomUUID().toString(),
                languageEnum.name(),
                new java.sql.Date(System.currentTimeMillis()),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                newsTag.name(),
                UUID.randomUUID().toString(),
                new java.sql.Date(System.currentTimeMillis())
        );
    }
}
