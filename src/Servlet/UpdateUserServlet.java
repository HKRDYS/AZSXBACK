package Servlet;

import DB.Dao.DaoImpl.UserDaoImpl;
import DB.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 功能:更改用户的信息
 * 参数需要: mode = ?
 * mode = "0"删除用户
 * mode = "1"添加用户（管理员）
 * mode = "2"更改用户信息
 *
 * URL :/AZSXBACK_war_exploded/UserUpdate
 *返回:json字符串数组
 */
@WebServlet(name = "UpdateUserServlet",value = "/UserUpdate")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String mode = "";
        try {
            mode=request.getParameter("mode");
        }catch (NullPointerException e){
            response.sendError(400,"请检查请求值，mode=?");
            e.printStackTrace();
        }catch (Exception e){
            response.sendError(500,"服务器数据库启动异常？");
        }
        if (mode.equals("")){
            response.sendError(400,"请检查请求值，mode=?");
        }
        else if(mode.equals("0")){
            String user = "";
            try {
                request.getParameter("user");
            }catch (NullPointerException e){
                response.sendError(400,"请检查请求值mode=0&user=?");
            }catch (Exception e){
                response.sendError(500,"数据库异常？");
            }
            UserDao userDao = new UserDaoImpl();
            int del = userDao.Del_User_Byusername(user);
            if(del != 0){
                PrintWriter out = response.getWriter();
                out.print("{\"del\":\"true\"");
            }else {
                PrintWriter out = response.getWriter();
                out.print("{\"del\":\"false\"");
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
