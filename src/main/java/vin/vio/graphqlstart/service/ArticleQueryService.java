package vin.vio.graphqlstart.service;

import vin.vio.graphqlstart.model.Article;
import vin.vio.graphqlstart.model.Author;
import vin.vio.graphqlstart.model.Tag;

import java.util.List;

public interface ArticleQueryService
{
    List<Article> listArticles();

    List<Tag> getTagsByArticleId(String articleId);

    Author getAuthorByAuthorId(String id);

    Article getArticleById(String id);
}
