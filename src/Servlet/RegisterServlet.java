package Servlet;

import DB.Dao.UserDao;
import DB.server.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String username="";
        String pwd="";
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            username = request.getParameter("username");
            pwd = request.getParameter("password");

        }catch (Exception e){
            System.out.println("请求错误！");
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            out.print("0");
            return;
        }
        UserDao us = new UserServer();
        int count = us.Find_UUid_ByUname(username);

        if (count != 0){
            PrintWriter out = response.getWriter();
            out.print("1");
        }
        else {
            Date date = new Date();//获得系统时间.
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
            String nowTime = sdf.format(date);
            try {
                Date time = sdf.parse( nowTime );
                count = us.Regist(username,pwd,time);
            } catch (ParseException e) {
                System.out.println("服务器异常!");
                e.printStackTrace();
                PrintWriter out = response.getWriter();
                out.print("0");
                return;
            }
            if(count == 1){
                PrintWriter out = response.getWriter();
                out.print("2");
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
