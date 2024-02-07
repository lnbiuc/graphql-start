package vin.vio.graphqlstart.service;

import vin.vio.graphqlstart.model.Article;
import vin.vio.graphqlstart.model.ArticleInput;

/**
 * @Description TODO
 * @Date 2024/2/7 17:14
 * @Created by ZZSLL
 */

public interface ArticleCreateService
{
    Article createArticle(ArticleInput article);
}
