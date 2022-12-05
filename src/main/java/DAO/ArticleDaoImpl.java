package DAO;

import DTO.Article;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ArticleDaoImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public Article addArticle(Article article) {
        return null;
    }

    @Override
    public List<Article> getAllArticles() {
        final String GET_ARTICLES = "SELECT * FROM Article;";
        List<Article> articles = jdbc.query(GET_ARTICLES, new ArticleMapper());
        return articles;
    }

    @Override
    public List<Article> getArticlesByID(int articleID) {
        return null;
    }

    @Override
    public List<Article> getArticlesByUser(int userID) {
        return null;
    }

    @Override
    public List<Article> getArticlesByTag(int tagID) {
        return null;
    }

    @Override
    public void updateArticle(Article article) {

    }

    @Override
    public void deleteArticle(Article article) {

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
