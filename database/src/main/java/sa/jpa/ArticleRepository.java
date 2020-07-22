package sa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.entities.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    List<Article> findAllBySourceId(String id);
}
