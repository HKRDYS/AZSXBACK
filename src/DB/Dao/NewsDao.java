package DB.Dao;


import DB.Bean.News;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Date 2020/1/2
 * 功能:新闻信息读取接口
 * */
public interface NewsDao {

    //显示所有新闻
    List<News>  FindNews_All();

    //按照日期正序显示所有新闻
    List<News>  FindNews_ByDate();

    //根据类型显示新闻
    List<News>  FindNews_ByType(String type);


    //根据阅读量筛选新闻
    List<News>  FindNews_ByCount(int max_count, int min_count);

    //根据阅读量升序排序新闻
    List<News>  FindNews_By_Count_Odascending();

    //根据阅读量降序排序新闻
    List<News> FindNews_By_Count_Oddescending();

    //添加新闻
    int Add_News(String headlines, String type, String details, String maker, Timestamp news_time, int uid);

    //根据id删除新闻
    int Del_News_ById(int id);

    //根据uid删除新闻
    int Del_News_ByUid(int uid);


    //显示所有新闻类别
    String[] Find_All_Type();

    //根据新闻名称和作者UID获取新闻ID
    int[] FindNewsId_ByNewsNameUID(String newshead, int uid);

    //根据新闻ID显示新闻作者UID
    int FindNewsUid_ByNewsId(int id);

    //根据新闻ID显示新闻
    News FindNews_ById(int id);

    //根据UID显示新闻
    List<News> FindNews_ByUid(int uid);

    //根据新闻ID更新新闻
    int UpdataNews_ById(int id, String headlnes, String type, Timestamp newstime, String maker, int n_count, String details, int uid);


    //根据新闻标题显示新闻
    List<News> Find_newsbyheadlines(String headlines);
}
