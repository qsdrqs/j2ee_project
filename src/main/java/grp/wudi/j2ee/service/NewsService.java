package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.News;
import java.util.List;

public interface NewsService {
    public News getNewsById(int id);

    /**
     * 通过关键词查询新闻
     * @param keyword 输入关键词字符串
     */
    public List<News> getNewsByKeyWord(String keyword);

    public int addNews(News news);
    public int updateNews(News news);
    public List<News> findall();
    public int deleteNews(int id);
}
