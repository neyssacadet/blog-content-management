package com.sg.DAO;

import com.sg.DTO.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public Article addArticle(Article article) {
        final String ADD_ARTICLE = "INSERT INTO Article(title, body, author, createdOn, postOn, expireOn)" +
                "VALUES(?,?,?,?,?,?);";
        jdbc.update(ADD_ARTICLE,
                article.getTitle(),
                article.getBody(),
                article.getAuthor(),
                article.getCreatedOn(),
                article.getPostOn(),
                article.getExpiredOn());

        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        article.setArticleID(newID);
        return article;
    }

    @Override
    public List<Article> getAllArticles() {
        final String GET_ARTICLES = "SELECT * FROM Article;";
        List<Article> articles = jdbc.query(GET_ARTICLES, new ArticleMapper());
        return articles;
    }

    @Override
    public Article getArticlesByID(int articleID) {
        try{
            final String GET_ARTICLE_BY_ID = "SELECT * FROM Article WHERE articleID = ?;";
            return jdbc.queryForObject(GET_ARTICLE_BY_ID, new ArticleMapper(), articleID);
        } catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Article> getArticlesByUser(String username) {
        return null;
    }

    @Override
    public List<Article> getArticlesByTag(int tagID) {
        return null;
    }

    @Override
    public void updateArticle(Article article) {
        final String UPDATE_ARTICLE = "UPDATE Article SET title = ?, body = ?, author = ? WHERE articleID = ?;";
        jdbc.update(UPDATE_ARTICLE,
                article.getTitle(),
                article.getBody(),
                article.getAuthor(),
                article.getArticleID());
    }

    @Override
    @Transactional
    public void deleteArticle(int articleID) {
        final String DELETE_ARTICLE_TAG = "DELETE FROM ArticleTag WHERE articleID = ?;";
        jdbc.update(DELETE_ARTICLE_TAG, articleID);

        final String DELETE_ARTICLE_COMMENT = "DELETE FROM ArticleComments WHERE articleID = ?;";
        jdbc.update(DELETE_ARTICLE_COMMENT, articleID);

        final String DELETE_ARTICLE = "DELETE FROM Article WHERE articleID = ?;";
        jdbc.update(DELETE_ARTICLE, articleID);
    }

    final public static class ArticleMapper implements RowMapper<Article>{
        @Override
        public Article mapRow(ResultSet rs, int index) throws SQLException {
            final Article article = new Article();
            article.setArticleID(rs.getInt("articleID"));
            article.setTitle(rs.getString("title"));
            article.setBody(rs.getString("body"));
            article.setAuthor(rs.getString("author"));
            article.setCreatedOn(rs.getDate("createdOn"));
            article.setPostOn(rs.getDate("postOn"));
            article.setExpiredOn(rs.getDate("expireOn"));
            return article;
        }
    }
}
