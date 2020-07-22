package sa.controllers;

import sa.entities.Article;
import sa.jpa.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleRestController {
    private ArticleRepository articleRepository;

    public ArticleRestController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/articles")
    public List<Article> getArticles() {
        return this.articleRepository.findAll();
    }
}
