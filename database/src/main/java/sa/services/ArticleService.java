package sa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.entities.Article;
import sa.jpa.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> getArticlesBySourceId(String id) {
        return articleRepository.findAllBySourceId(id);
    }

    public Article getArticle(String id) {
        return articleRepository.getOne(id);
    }

    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    public void addAllArticles(List<Article> articles) {
        articleRepository.saveAll(articles);
    }

    public void removeArticle(String id) {
        articleRepository.deleteById(id);
    }
}
