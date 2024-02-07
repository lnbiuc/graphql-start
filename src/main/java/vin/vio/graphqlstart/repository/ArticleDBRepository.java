package vin.vio.graphqlstart.repository;

import org.springframework.stereotype.Repository;
import vin.vio.graphqlstart.model.Article;
import vin.vio.graphqlstart.model.Author;
import vin.vio.graphqlstart.model.Tag;

import java.util.*;

/**
 * @Description TODO
 * @Date 2024/2/7 15:36
 * @Created by ZZSLL
 */

@Repository
public class ArticleDBRepository
{
    private final List<Article> articles = Arrays.asList(
            new Article("1", "title1", "content1", "author-1", "1"),
            new Article("2", "title2", "content2", "author-2", "2"),
            new Article("3", "title3", "content3", "author-3", "3"),
            new Article("4", "title4", "content4", "author-1", "4"),
            new Article("5", "title5", "content5", "author-2", "5")
    );

    private final Map<String, List<Tag>> tags = new HashMap<>() {{
        put("1", List.of(new Tag("1", "Java", "Java related articles"), new Tag("2", "Python", "Python related articles"), new Tag("1", "Java", "Java related articles")));
        put("2", List.of(new Tag("2", "Python", "Python related articles"), new Tag("3", "JavaScript", "JavaScript related articles")));
        put("3", List.of(new Tag("3", "JavaScript", "JavaScript related articles")));
        put("4", List.of(new Tag("4", "Kotlin", "Kotlin related articles"), new Tag("5", "Go", "Go related articles"), new Tag("6", "Rust", "Rust related articles")));
        put("5", List.of(new Tag("5", "Go", "Go related articles")));
    }};

    private final List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson")
    );

    public Article getArticleById(String id) {
        return articles.stream()
                .filter(article -> article.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Article> allArticles() {
        return articles;
    }

    public List<Tag> getTagsForArticle(String articleId) {
        return tags.get(articleId);
    }

    public Author findAuthorByArticleId(String id)
    {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
