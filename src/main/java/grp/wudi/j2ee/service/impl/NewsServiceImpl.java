package grp.wudi.j2ee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.wudi.j2ee.dao.NewsDao;
import grp.wudi.j2ee.entity.News;
import grp.wudi.j2ee.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public News getNewsById(int id) {
        return newsDao.findById(id);
    }

    @Override
    public List<News> getNewsByKeyWord(String keyword) {
        return newsDao.findByKeyword(keyword);
    }

    @Override
    public int addNews(News news) {
        return newsDao.addNews(news);
    }

    @Override
    public int updateNews(News news) {
        return newsDao.update(news);
    }

    @Override
    public List<News> findall() {
        return newsDao.findAll();
    }

    @Override
    public int deleteNews(int id) {
        return newsDao.removeNews(id);
    }

}
