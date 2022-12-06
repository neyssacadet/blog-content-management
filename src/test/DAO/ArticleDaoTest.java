package DAO;

import com.sg.DTO.Article;
import com.sg.DAO.ArticleDao;
import com.sg.TestApplicationConfiguration;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class ArticleDaoTest {
    @Autowired
    ArticleDao articleDao;

    public ArticleDaoTest(){

    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        List<Article> articles = articleDao.getAllArticles();
        for(Article article : articles) {
            articleDao.deleteArticle(article.getArticleID());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddAndGetArticle(){
        Article article = new Article();
        Date date = new Date(2022,11,12);
        article.setTitle("The Little Mermaid");
        article.setBody("Under the Sea");
        article.setAuthor("Test Author name");
        article.setCreatedOn(date);
        article.setPostOn(date);
        article.setExpiredOn(date);

        article = articleDao.addArticle(article);
        Article fromDao = articleDao.getArticlesByID(article.getArticleID());

        assertEquals(article, fromDao);
    }

    @Test
    public void testGetAllArticles(){
        Date date = new Date(2022,11,12);
        Article article = new Article();
        article.setTitle("The Little Mermaid");
        article.setBody("Under the Sea");
        article.setAuthor("Test Author");
        article.setCreatedOn(date);
        article.setPostOn(date);
        article.setExpiredOn(date);

        article = articleDao.addArticle(article);

        Article article2 = new Article();
        article2.setTitle("The Little Mermaid");
        article2.setBody("Under the Sea");
        article2.setAuthor("Test Author");
        article2.setCreatedOn(date);
        article2.setPostOn(date);
        article2.setExpiredOn(date);
        article2 = articleDao.addArticle(article2);

        List<Article> articles = articleDao.getAllArticles();

        assertEquals(2, articles.size());
        assertTrue(articles.contains(article));
        assertTrue(articles.contains(article2));
    }

    @Test
    public void testUpdateArticle(){
        Date date = new Date(2022,11,12);
        Article article = new Article();
        article.setTitle("The Little Mermaid");
        article.setBody("Under the Sea");
        article.setAuthor("Test Author");
        article.setCreatedOn(date);
        article.setPostOn(date);
        article.setExpiredOn(date);

        article = articleDao.addArticle(article);
        Article fromDao = articleDao.getArticlesByID(article.getArticleID());
        assertEquals(article, fromDao);

        article.setBody("New Body");
        articleDao.updateArticle(article);

        assertNotEquals(article, fromDao);

        fromDao = articleDao.getArticlesByID(article.getArticleID());

        assertEquals(article, fromDao);
    }

    @Test
    public void testDeleteArticle(){
        Date date = new Date(2022,11,12);
        Article article = new Article();
        article.setTitle("The Little Mermaid");
        article.setBody("Under the Sea");
        article.setAuthor("Test Author");
        article.setCreatedOn(date);
        article.setPostOn(date);
        article.setExpiredOn(date);

        article = articleDao.addArticle(article);
        Article fromDao = articleDao.getArticlesByID(article.getArticleID());
        assertEquals(article, fromDao);

        articleDao.deleteArticle(article.getArticleID());

        fromDao = articleDao.getArticlesByID(article.getArticleID());
        assertNull(fromDao);
    }
}
