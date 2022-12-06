package DAO;

import BlogContentManagement.TestApplicationConfiguration;
import DTO.Article;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class ArticleDaoTest {
    @Autowired
    ArticleDaoImpl articleDao;

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
        Article article = new Article();
        article.setTitle("The Little Mermaid");
        article.setBody("Under the Sea");
        article = articleDao.addArticle(article);

        Article article2 = new Article();
        article2.setTitle("The Little Mermaid");
        article2.setBody("Under the Sea");
        article2 = articleDao.addArticle(article2);

        List<Article> articles = articleDao.getAllArticles();

        assertEquals(2, articles.size());
        assertTrue(articles.contains(article));
        assertTrue(articles.contains(article2));
    }
}
