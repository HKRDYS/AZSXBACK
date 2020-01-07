package DB.server;

import DB.Bean.News;
import DB.Dao.DaoImpl.NewsDaoImpl;

import java.sql.Timestamp;
import java.util.List;

public class NewsServer extends NewsDaoImpl {
    @Override
    public List<News> FindNews_All() {
        return super.FindNews_All();
    }

    @Override
    public List<News> FindNews_ByDate() {
        return super.FindNews_ByDate();
    }

    @Override
    public List<News> FindNews_ByType(String type) {
        return super.FindNews_ByType(type);
    }

    @Override
    public List<News> FindNews_ByCount(int max_count, int min_count) {
        return super.FindNews_ByCount(max_count, min_count);
    }

    @Override
    public List<News> FindNews_By_Count_Odascending() {
        return super.FindNews_By_Count_Odascending();
    }

    @Override
    public List<News> FindNews_By_Count_Oddescending() {
        return super.FindNews_By_Count_Oddescending();
    }

    @Override
    public int Add_News(String headlines, String type, String details, String maker, Timestamp news_time, int uid) {
        return super.Add_News(headlines, type, details, maker, news_time, uid);
    }

    @Override
    public int Del_News_ById(int id) {
        return super.Del_News_ById(id);
    }

    @Override
    public int Del_News_ByUid(int uid) {
        return super.Del_News_ByUid(uid);
    }

    @Override
    public String[] Find_All_Type() {
        return super.Find_All_Type();
    }

    @Override
    public int[] FindNewsId_ByNewsNameUID(String newshead, int uid) {
        return super.FindNewsId_ByNewsNameUID(newshead, uid);
    }

    @Override
    public int FindNewsUid_ByNewsId(int id) {
        return super.FindNewsUid_ByNewsId(id);
    }

    @Override
    public News FindNews_ById(int id) {
        return super.FindNews_ById(id);
    }

    @Override
    public List<News> FindNews_ByUid(int uid) {
        return super.FindNews_ByUid(uid);
    }

    @Override
    public int UpdataNews_ById(int id, String headlnes, String type, Timestamp newstime, String maker, int n_count, String details, int uid) {
        return super.UpdataNews_ById(id, headlnes, type, newstime, maker, n_count, details, uid);
    }

    @Override
    public int getReturn_number() {
        return super.getReturn_number();
    }
}
