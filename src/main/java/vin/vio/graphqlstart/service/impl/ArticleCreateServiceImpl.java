package vin.vio.graphqlstart.service.impl;

import org.springframework.stereotype.Service;
import vin.vio.graphqlstart.model.Article;
import vin.vio.graphqlstart.model.ArticleInput;
import vin.vio.graphqlstart.repository.DBRepository;
import vin.vio.graphqlstart.service.ArticleCreateService;

/**
 * @Description TODO
 * @Date 2024/2/7 17:14
 * @Created by ZZSLL
 */

@Service
public class ArticleCreateServiceImpl implements ArticleCreateService
{
    private final DBRepository repository;

    public ArticleCreateServiceImpl(DBRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Article createArticle(ArticleInput article)
    {
        return repository.saveArticle(article);
    }
}
