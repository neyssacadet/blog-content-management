package DAO;

import DTO.Article;

import java.util.List;

/**
 *@author : Claude Seide, Everlyn Leon, Mariya Malakhava, Neyssa Cadet
 *
 */

public interface ArticleDao {
    //get one, get all
    //get by category
    //add one
    //update one
    //delete one

    public Article addArticle(Article article);

    public List<Article> getAllArticles ();

    public Article getArticlesByID(int articleID);

    public List<Article> getArticlesByUser(int userID);

    public List<Article> getArticlesByTag (int tagID);

    public void updateArticle(Article article);

    public void deleteArticle(int articleID);
}
