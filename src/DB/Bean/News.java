package DB.Bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *日期:2019/12/31
 * 功能:新闻信息实体类
 * */
public class News {
    //新闻ID
    private int id;
    //新闻标题
    private String headlines;

    //新闻内容
    private String details;

    //新闻类型
    private String newstype;

    //新闻时间
    private Timestamp newsdate;

    //新闻作者
    private String maker;

    //新闻阅读量
    private int count;

    //新闻作者uid
    private int uid;


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public Timestamp getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(Timestamp newsdate) {
        this.newsdate = newsdate;
    }


    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getHeadlines() {
        return headlines;
    }

    public void setNewshead(String headlines) {
        this.headlines = headlines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
