package grp.wudi.j2ee.entity;

import java.util.Date;

public class News {

    private int newsId; //新闻id
    private String title; //标题
    private String contentPath;//内容路径
    private int type; //新闻类型：0.房地产新闻 1.房价走向 2.二手房市场
    private Date createTime;

    public News(){
        setCreateTime(new Date());
    }

    public News(String title, String contentPath, int type) {
        this.title = title;
        this.contentPath = contentPath;
        this.type = type;
        Date date = new Date();
        setCreateTime(date);
    }

    public int getNewsId() {
        return newsId;
    }
    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentPath() {
        return contentPath;
    }
    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString(){
        return "newsId=" + newsId + "title=" + title + "contentPath=" + contentPath;
    }


}
