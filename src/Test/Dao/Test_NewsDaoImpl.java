package Test.Dao;


import DB.Bean.News;
import DB.Dao.DaoImpl.NewsDaoImpl;
import DB.Dao.NewsDao;
import org.junit.Test;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Test_NewsDaoImpl {
    /**
     * Date 2020/1/3
     * 新闻测试类输出方法
     * @param news_list 新闻数据类返回集合
     * */

    private void News_Print(List<News> news_list){
        for (int i = 0; i < news_list.size(); i++) {
            System.out.println("新闻标题: "+
                    news_list.get(i).getHeadlines());
            System.out.println("新闻浏览量: "+
                    news_list.get(i).getCount());
            System.out.println("新闻ID: "+
                    news_list.get(i).getId());
            System.out.println("新闻作者: "+
                    news_list.get(i).getMaker());
            System.out.println("新闻发表日期: "+
                    news_list.get(i).getNewsdate());
            System.out.println("新闻类型: "+
                    news_list.get(i).getNewstype());
            System.out.println("新闻内容: "+
                    news_list.get(i).getDetails());
            System.out.println("第"+ i +"组数据测试完成！"+"\n");
        }
    }
    //测试显示所有新闻
    @Test
    public void Test_FindNews_All() {
        NewsDao t1 = new NewsDaoImpl();
        List<News> L2 = t1.FindNews_All();
        News_Print(L2);
    }


    //测试日期显示（按日期显示所有新闻）
    @Test
    public void Test_FindNews_ByDate(){
        NewsDao t2 = new NewsDaoImpl();
        List<News> L1 = t2.FindNews_ByDate();
        News_Print(L1);
    }


    //测试更具类型显示新闻
    @Test
    public void Test_FindNews_ByType(){
        NewsDao t3=new NewsDaoImpl();
        List<News> L3=t3.FindNews_ByType("测试时间空项");
        News_Print(L3);
    }

    //测试根据阅读量筛选新闻
    @Test
    public void Test_FindNews_ByCount(){
        NewsDao t4=new NewsDaoImpl();
        List<News> L4=t4.FindNews_ByCount
                (99,2);
        News_Print(L4);
    }


    //测试根据阅读量升序排序新闻
    @Test
    public void Test_FindNews_By_Count_Odascending(){
        NewsDao t5=new NewsDaoImpl();
        List<News> L5=t5.FindNews_By_Count_Odascending();
        News_Print(L5);
    }


    //测试根据阅读量降序排序新闻
    @Test
    public void Test_FindNews_By_Count_Oddescending(){
        NewsDao t6=new NewsDaoImpl();
        List<News> L6=t6.FindNews_By_Count_Oddescending();
        News_Print(L6);
    }


    //测试添加新闻
    @Test
    public void Test_Add_News(){
        NewsDao t7=new NewsDaoImpl();
        int t = 2;
        long tm = System.currentTimeMillis();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = "2017-11-20 21:32:11";
        java.util.Date date=null;
        try{
            date=sd.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Timestamp dateSQL = new Timestamp(date.getTime());

        int L7=t7.Add_News("测试新闻2","新闻杂项",
                "徐凤年","轩辕青锋nd",dateSQL,2);
        System.out.println("成功添加:"+L7);
    }

    //测试根据id删除新闻
    @Test
    public void Test_Del_News_ById(){
        NewsDao t8=new NewsDaoImpl();
        int L8=t8.Del_News_ById(1);
        System.out.println(L8);
    }

    //测试根据uid删除新闻
    @Test
    public void Test_Del_News_ByUid(){
        NewsDao t9=new NewsDaoImpl();
        int L9=t9.Del_News_ByUid(2);
        System.out.println(L9);
    }



    //测试显示所有新闻类别
    @Test
    public void Test_Find_All_Type() {
        NewsDao t10=new NewsDaoImpl();
        String[] L10=t10.Find_All_Type();
        for (String i : L10){
            System.out.println(i);
        }
    }

    //测试根据新闻名称和作者UID获取新闻ID
    @Test
    public void Test_FindNewsId_ByNewsNameUID(){
        NewsDao t11=new NewsDaoImpl();
        int[] L11=t11.FindNewsId_ByNewsNameUID("测试新闻06",1);
        for(int i : L11){
            System.out.println(i);
        }

    }

    //测试根据新闻ID显示新闻作者UID
    @Test
    public void Test_FindNewsUid_ByNewsId(){
        NewsDao t12=new NewsDaoImpl();
        int L12=t12.FindNewsUid_ByNewsId(5);
        System.out.println(L12);
    }

    //测试根据新闻ID显示新闻
    @Test
    public void Test_FindNews_ById(){
        NewsDao t13=new NewsDaoImpl();
        News L13=t13.FindNews_ById(8);
        System.out.println(L13.getDetails()+"   " +
                " "+L13.getMaker());
    }

    //测试根据UID显示新闻
    @Test
    public void Test_FindNews_ByUid(){
        NewsDao t14=new NewsDaoImpl();
        List<News> L14=t14.FindNews_ByUid(2);
        News_Print(L14);
    }
    //根据新闻ID更新新闻
    @Test
    public void Test_UpdataNews_ById(){
        NewsDao t15=new NewsDaoImpl();
        int t = 2;
        long tm = System.currentTimeMillis();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = "2017-11-20 21:32:11";
        java.util.Date date=null;
        try{
            date=sd.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Timestamp dateSQL = new Timestamp(date.getTime());
        int L15=t15.UpdataNews_ById(4,"测试新闻07","新闻杂项",dateSQL ,"轩辕城",7,"组长不给加班工资，全体罢工！",1);
        System.out.println(L15);
    }

    //测试根据新闻标题显示新闻
    @Test
    public void Test_Find_newsbyheadlines(){
        NewsDao t16= new NewsDaoImpl();
        List<News> L16=t16.Find_NewsByHeadLines("测试新闻07");
        News_Print(L16);
    }


}