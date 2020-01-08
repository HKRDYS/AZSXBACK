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
import java.util.Date;
import java.util.List;

/**
 * 功能:实现返回所有新闻
 *
 * */
@WebServlet(name = "News_FindAll_Servlet" ,value = "/AllNews")
public class News_FindAll_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String re = request.getParameter("FindAllNews");
        if (re.equals("findall")){
            NewsDao allnews = new NewsServer();
            List<News> lsNews = allnews.FindNews_All();
            StringBuffer rs_news = new StringBuffer();
            rs_news.append("{\"");
            for (int i = 0; i < lsNews.size(); i++) {
                int id = lsNews.get(i).getId();
                String s_id = String.valueOf(id);
                String headlines = lsNews.get(i).getHeadlines();
                Date newstime = lsNews.get(i).getNewsdate();
                String s_newstime = String.valueOf(newstime);

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
