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
 * */

@WebServlet(name = "LoginTempServlet",value = "/TLogin")
public class LoginTempServlet extends HttpServlet {
    /**
     * 接受参数请求形式:POST
     * 参数需要: username，password,login_type(0为用户名登录，1为电话号码登录)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
            String mode = request.getParameter("login_type");

            String type = "'false'";
            //设置输出对象
            PrintWriter out = response.getWriter();

            //判断用户登录模式
            switch (mode) {
                //用户名登录
                case ("0"): {
                    if (username.equals("test") & pwd.equals("1")) {
                        //设置输出值
                        type = "'true'";
                        String str = "{'login_type':"
                                + type
                                + "}";
                        //输出对象
                        out.print(str);
                    }
                }
                //电话登录
                case ("1"): {
                    if (username.equals("123456") & pwd.equals("1")) {
                        type = "'true'";
                        String str = "{'login_type':"
                                + type
                                + "}";
                        //输出
                        out.print(str);
                    }
                }
                default: {
                    String str = "{'login_type':"
                            + type
                            + "}";
                    out.print(str);
                }
            }
        }catch (Exception e){
            System.out.println("请求错误!");
            //设置输出对象
            PrintWriter out = response.getWriter();
            out.print("'login_type':'false'");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
            String mode = request.getParameter("login_type");

            String type = "'false'";
            //设置输出对象
            PrintWriter out = response.getWriter();

            //判断用户登录模式
            switch (mode) {
                //用户名登录
                case ("0"): {
                    if (username.equals("test") & pwd.equals("1")) {
                        //设置输出值
                        type = "'true'";
                        String str = "{'login_type':"
                                + type
                                + "}";
                        //输出对象
                        out.print(str);
                    }
                }
                //电话登录
                case ("1"): {
                    if (username.equals("123456") & pwd.equals("1")) {
                        type = "'true'";
                        String str = "{'login_type':"
                                + type
                                + "}";
                        //输出
                        out.print(str);
                    }
                }
                default: {
                    String str = "{'login_type':"
                            + type
                            + "}";
                    out.print(str);
                }
            }
        }catch (Exception e){
            System.out.println("请求错误!");
            //设置输出对象
            PrintWriter out = response.getWriter();
            out.print("'login_type':'false'");
            e.printStackTrace();
        }
    }
}
