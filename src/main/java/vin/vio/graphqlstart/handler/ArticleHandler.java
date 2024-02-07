package vin.vio.graphqlstart.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import vin.vio.graphqlstart.model.*;
import vin.vio.graphqlstart.service.ArticleCreateService;
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

    private final ArticleCreateService createService;

    public ArticleHandler(ArticleQueryService queryService, ArticleCreateService createService)
    {
        this.queryService = queryService;
        this.createService = createService;
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

    @MutationMapping
    public Article createArticle(@Argument("article") ArticleInput article) {
        return createService.createArticle(article);
    }
}
