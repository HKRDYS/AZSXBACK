package Servlet;

import DB.Bean.News;
import DB.Dao.DaoImpl.NewsDaoImpl;
import DB.Dao.NewsDao;
import DB.server.NewsServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 功能:实现返回所有新闻
 *URL: /AZSXBACK_war_exploded/News
 * */
@WebServlet(name = "News_FindServlet" ,value = "/News")
public class News_FindServlet extends HttpServlet {
    /**
     * 需要参数:find = ?
     * Find 可以为: all , bytype
     * 返回:json字符串
     * 格式{"key":[key1:value1,key2:value2 ... key8:value8]}
     * */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            //获取请求类型
            String re = request.getParameter("find");
            System.out.println(re);
            //如果请求值为find = all (显示所有新闻)
            if (re.equals("all")){
                NewsDao allnews = new NewsServer();
                List<News> lsNews = allnews.FindNews_All();
                String re_news = Print_Helper(lsNews) ;
                PrintWriter out = response.getWriter();
                out.print(re_news);
            }
            //如果请求值find = bytype(按新闻类型查询)
            else if(re.equals("bytype")){
                String type = request.getParameter("type");
                if(type.equals("")){
                    response.sendError(400, "预期之外的请求类型!请检查请求值，type =?" );
                    return;
                }
                NewsDao newsDao = new NewsServer();
                List<News> lsNews = newsDao.FindNews_ByType(type);
                //将数组集转换为json数组并输出
                String re_news = Print_Helper(lsNews);
                PrintWriter out = response.getWriter();
                out.print(re_news);
            }
            //如果请求值find = dateorder;
            else if(re.equals("dateorder")){
                NewsDao newsDao = new NewsServer();
                List<News> lsNews = newsDao.FindNews_ByDate();
                //将数组集转换为json数组并输出
                String re_news = Print_Helper(lsNews);
                PrintWriter out = response.getWriter();
                out.print(re_news);
            }
            //显示所有新闻类型
            else if(re.equals("type")){
                NewsDao newsDao = new NewsServer();
                String[] arr = newsDao.Find_All_Type();
                StringBuffer sb = new StringBuffer();
                sb.append("{");
                int id = 0;
                for (String n :arr){
                    id++;
                    String s_id =  String.valueOf(id);
                    sb.append("\""+s_id+"\":");
                    sb.append("\""+n+"\"");
                    if(id<arr.length){
                        sb.append(",");
                    }else {
                        sb.append("}");
                    }
                }
                PrintWriter out = response.getWriter();
                out.print(sb);
            }
            //如果是根据新闻标题返回新闻
            else if(re.equals("byname")){
                NewsDao newsDao = new NewsDaoImpl();
                String name = "";
                try {
                    name = request.getParameter("name");
                }catch (NullPointerException e){
                    response.sendError(400, "预期之外的请求类型!请检查请求值，name =?" );
                    e.printStackTrace();
                }
                if(name.equals("")){
                    response.sendError(400, "预期之外的请求类型!请检查请求值，name =?" );
                    return;
                }
                List<News> lsNews = newsDao.Find_NewsByHeadLines(name);
                //将数组集转换为json数组并输出
                String re_news = Print_Helper(lsNews);
                PrintWriter out = response.getWriter();
                out.print(re_news);


            }
            /*
             * 功能:通过新闻id访问新闻
             * id = ?
             *
             * */
            else if(re.equals("byid")){
                NewsDao newsDao = new NewsDaoImpl();
                String s_id = "";
                int id =0;
                try {
                    s_id = request.getParameter("id");
                    id = new Integer(s_id);
                }catch (NullPointerException e){
                    response.sendError(400, "预期之外的请求类型!请检查请求值，id =?" );
                    e.printStackTrace();
                }
                if(id == 0){
                    response.sendError(400, "预期之外的请求类型!请检查请求值，id =?" );
                    return;
                }
                News news = newsDao.FindNews_ById(id);
                List<News>  lsnews = new ArrayList<News>();
                lsnews.add(news);
                PrintWriter out = response.getWriter();
                out.print(Print_Helper(lsnews));
            }

            //请求值为预期之外
            else {

                response.sendError(400,"预期之外的请求类型!请检查请求值,find=?");
            }
        }catch (Exception e){
            response.sendError(400, "请检查请求的参数,find?" );
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request,response);
    }

    /**
     * 功能:将News集合转为json数组
     * @param tlnews News集合
     * @return json数组 {"key(newsdata)":["key(id)":["value(headlines)","value(type)","value(newstime)","value(maker)"，"value(n_count)","value(details)","value(uid)"]]}
     * */
    private String Print_Helper(List<News> tlnews){
        StringBuffer rs_news = new StringBuffer();
        rs_news.append("{");
        rs_news.append("\"newsdata\":[{");
        for (int i = 0; i < tlnews.size(); i++) {
            int id = tlnews.get(i).getId();
            String s_id = String.valueOf(id);
            String headlines = tlnews.get(i).getHeadlines();
            Date newstime = tlnews.get(i).getNewsdate();
            String s_newstime = String.valueOf(newstime);
            String maker = tlnews.get(i).getMaker();
            int count = tlnews.get(i).getCount();
            String s_count = String.valueOf(count);
            String details = tlnews.get(i).getDetails();
            int uid = tlnews.get(i).getUid();
            String type = tlnews.get(i).getNewstype();
            String s_uid = String.valueOf(uid);
            //获取并封装news
            String arr[] = {headlines,s_newstime,maker,s_count,details,s_uid};
            rs_news.append("\""+s_id+"\":");
            rs_news.append("[");
            //初始化预读取列表长度
            int n = 0;
            for(String s : arr){
                n+=1;
                rs_news.append("\""+s+"\"");
                //n的比较值为arr的长度
                if(n<arr.length){
                    rs_news.append(",");
                }
            }
            if(i<tlnews.size()-1){
                //设置json字符串结尾
                rs_news.append("]"+"}"+",");
            }
            else {
                //设置json数组字符串结尾
                rs_news.append("]}]");
            }
        }
        rs_news.append("}");
        //返回封装的json数组
        return rs_news.toString();
    }
}
