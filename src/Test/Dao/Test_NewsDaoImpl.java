package Test.Dao;


import DB.Bean.News;
import DB.Dao.DaoImpl.NewsDaoImpl;
import DB.Dao.NewsDao;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test_NewsDaoImpl {
    /**
     * Date 2020/1/3
     * 新闻测试类输出方法
     * @param news_list 新闻数据类返回集合
     * */

    private void News_Print(List<News> news_list){
        for (int i = 0; i < news_list.size(); i++) {
            System.out.println("新闻标题: "+ news_list.get(i).getHeadlines());
            System.out.println("新闻浏览量: "+ news_list.get(i).getCount());
            System.out.println("新闻ID: "+ news_list.get(i).getId());
            System.out.println("新闻作者: "+ news_list.get(i).getMaker());
            System.out.println("新闻发表日期: "+news_list.get(i).getNewsdate());
            System.out.println("新闻类型: "+news_list.get(i).getNewstype());
            System.out.println("新闻内容: "+news_list.get(i).getDetails());
            System.out.println("第"+ i +"组数据测试完成！"+"\n");
        }
    }

    @Test
    public void Test_FindNews_All() {
        NewsDao t1 = new NewsDaoImpl();
        List<News> L2 = t1.FindNews_All();
        News_Print(L2);
    }

    //测试日期显示
    @Test
    public void Test_FindNews_ByDate(){
        NewsDao t2 = new NewsDaoImpl();
        List<News> L1 = t2.FindNews_ByDate();
        News_Print(L1);
    }
}