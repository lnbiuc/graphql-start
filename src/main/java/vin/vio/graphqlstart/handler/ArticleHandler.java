package vin.vio.graphqlstart.handler;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import vin.vio.graphqlstart.model.Article;
import vin.vio.graphqlstart.model.Author;
import vin.vio.graphqlstart.model.Tag;
import vin.vio.graphqlstart.service.ArticleQueryService;

import java.util.Collection;

/**
 * @Description TODO
 * @Date 2024/2/7 15:35
 * @Created by ZZSLL
 */

@Controller
public class ArticleHandler
{
    private final ArticleQueryService queryService;

    public ArticleHandler(ArticleQueryService queryService)
    {
        this.queryService = queryService;
    }

    @QueryMapping
    public Collection<Article> articles()
    {
        return queryService.listArticles();
    }

    @QueryMapping
    public Article article(@Argument String id) {
        return queryService.getArticleById(id);
    }

    @SchemaMapping
    public Collection<Tag> tags(Article article)
    {
        return queryService.getTagsByArticleId(article.id());
    }

    @SchemaMapping
    public Author author(Article article)
    {
        return queryService.getAuthorByAuthorId(article.authorId());
    }
}
