package grp.wudi.j2ee.dao;

import java.util.List;

import grp.wudi.j2ee.entity.News;


public interface NewsDao {

    public News findById(int id);
    public List<News> findByKeyword(String keyword);
    public int addNews(News news);
    public int update(News news);
    public List<News> findAll();
    public int removeNews(int id);

}
