package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by xiaolintuoer on 2020/1/5
 * 功能：实现用户信息临时验证（未连接数据库）
 * URL:  /TLogin
 * */

@WebServlet(name = "LoginTempServlet",value = "/TLogin")
public class LoginTempServlet extends HttpServlet {
    /**
     * 参数需要: username，password
     * 默认的验证参数:username = test , password = 123456
     *
     * 如果登录成功返回 "true"
     * 登录失败返回 "false"
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
            //设置输出对象
            PrintWriter out = response.getWriter();
            if(username.equals("test")&pwd.equals("123456")){
                out.print("true");
            }else {
                out.print("false");
            }

        }catch (Exception e){
            System.out.println("请求错误!");
            //设置输出对象
            PrintWriter out = response.getWriter();
            out.print("false");
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
