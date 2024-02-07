package vin.vio.graphqlstart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vin.vio.graphqlstart.model.Article;
import vin.vio.graphqlstart.model.Author;
import vin.vio.graphqlstart.model.Tag;
import vin.vio.graphqlstart.repository.ArticleDBRepository;
import vin.vio.graphqlstart.service.ArticleQueryService;

import java.util.List;

/**
 * @Description TODO
 * @Date 2024/2/7 15:36
 * @Created by ZZSLL
 */

@Service
public class ArticleQueryServiceImpl implements ArticleQueryService
{
    @Autowired
    private ArticleDBRepository repository;

    @Override
    public List<Article> listArticles()
    {
        return repository.allArticles();
    }

    @Override
    public List<Tag> getTagsByArticleId(String articleId)
    {
        return repository.getTagsForArticle(articleId);
    }

    @Override
    public Author getAuthorByAuthorId(String id)
    {
        return repository.findAuthorByArticleId(id);
    }

    @Override
    public Article getArticleById(String id)
    {
        return repository.getArticleById(id);
    }
}
