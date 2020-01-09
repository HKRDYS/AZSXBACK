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

/**
 * 功能：接受来自安卓前端的注册请求
 * URL:/AZSXBACK_war_exploded/Register
 * */
@WebServlet(name = "RegisterServlet",value = "/Register")
public class RegisterServlet extends HttpServlet {
    /**
     * 需要参数:username,password
     *
     * 返回值说明:1=用户名已被注册，2=注册成功
     *
     * */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String username="";
        String pwd="";
        response.setContentType("text/html;charset=utf-8");
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            username = request.getParameter("username");
            pwd = request.getParameter("password");

        }catch (Exception e){
            e.printStackTrace();
            response.sendError(400, "预期之外的请求值，请检查username =?,password=? " );
            return;
        }
        UserDao us = new UserServer();
        int count = us.Find_UUid_ByUname(username);

        if (count != 0){
            PrintWriter out = response.getWriter();
            out.print("{\"register\":\"1\"}");
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
                response.sendError(500, "服务器内部错误" );
                return;
            }

            if(count == 1){
                PrintWriter out = response.getWriter();
                out.print("{\"register\":\"2\"}");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request,response);
    }
}
