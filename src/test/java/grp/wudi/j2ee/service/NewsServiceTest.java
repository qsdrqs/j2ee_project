package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.News;
import grp.wudi.j2ee.service.NewsService;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void testAdd() throws Exception {
        News news = new News();
        news.setType(0);
        news.setTitle("房价大缩水！母猪竟上树！");
        news.setContentPath("news");
        newsService.addNews(news);

    }

    @Test
    public void testGetNewsById() throws Exception {
        System.out.println(newsService.getNewsById(1));
    }

    @Test
    public void testUpdateNews() throws Exception {
        News news =new News();
        news.setNewsId(1);
        news.setContentPath("news/"+news.getNewsId()+".html");
        news.setType(1);
        newsService.updateNews(news);
    }

    @Test
    public void testGetNewsByKeyword() throws Exception {
        System.out.println(newsService.getNewsByKeyWord("猪"));
    }

    @Test
    public void testFindAll() throws Exception {
        List<News> list=newsService.findall();
        for(News news:list){
            System.out.println(news);
        }
    }

    @Test
    public void testDeleteNews(){
        newsService.deleteNews(1);
    }
}
