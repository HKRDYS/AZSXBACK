package Servlet;

import DB.Bean.News;
import DB.Dao.NewsDao;
import DB.server.NewsServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * 功能:实现返回所有新闻
 *
 * */
@WebServlet(name = "News_FindAll_Servlet" ,value = "/News")
public class News_FindAll_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            String re = request.getParameter("Find");
            System.out.println(re);
            if (re.equals("all")){
                NewsDao allnews = new NewsServer();
                List<News> lsNews = allnews.FindNews_All();
                StringBuffer rs_news = new StringBuffer();
                rs_news.append("{");
                for (int i = 0; i < lsNews.size(); i++) {
                    int id = lsNews.get(i).getId();
                    String s_id = String.valueOf(id);
                    String headlines = lsNews.get(i).getHeadlines();
                    Date newstime = lsNews.get(i).getNewsdate();
                    String s_newstime = String.valueOf(newstime);
                    String maker = lsNews.get(i).getMaker();
                    int count = lsNews.get(i).getCount();
                    String s_count = String.valueOf(count);
                    String details = lsNews.get(i).getDetails();
                    int uid = lsNews.get(i).getUid();
                    String s_uid = String.valueOf(uid);
                    //获取并封装news
                    String arr[] = {headlines,s_newstime,maker,s_count,details,s_uid};
                    rs_news.append("\""+s_id+"\":");
                    rs_news.append("[");
                    for(String s : arr){

                        rs_news.append("\""+s+"\",");
                    }
                    rs_news.append("]\""+",");
                }
                PrintWriter out = response.getWriter();
                out.print(rs_news.toString());
            }else {
                PrintWriter out = response.getWriter();
                out.print("请检查请求值！");
            }
        }catch (Exception e){
            PrintWriter out = response.getWriter();
            out.print("null!");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request,response);
    }
}
