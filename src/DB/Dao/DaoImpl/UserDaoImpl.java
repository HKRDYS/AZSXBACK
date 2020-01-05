package DB.Dao.DaoImpl;

import DB.Bean.User;
import DB.DBhelper.ConnectionManager;
import DB.Dao.UserDao;

import java.rmi.server.RemoteRef;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public int Regist(String username, String password,Date registrdate) {
        //初始化返回值
        int count = 0;
        //获取数据库连接
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字段
        String sql = "insert into user_info (username, password, registr_date) values(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //将注册时间转换为SQL时间储存
            java.sql.Date sqlDate=new java.sql.Date(registrdate.getTime());
            //设置占位符
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setDate(3,sqlDate);
            //提交更新,返回更新条数
            count = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.closeConnection(conn);
        }
        return count;
    }

    @Override
    public boolean Login(String username, String password) {
        //默认登录状态为false
        boolean is_login = false;
        Connection conn = ConnectionManager.getConnection();
        String sql = "select * from user_info where username=? and password = ?";
        try {
            //创建数据库语句预备对象
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                is_login = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.closeConnection(conn);
        }
        return is_login;
    }

    @Override
    public int Add_UserInfo(String username,String phone_number, String email, Date birthday) {
        //返回添加成功条数
        int count = 1;
        //初始化数据库连接，定义SQL语句
        Connection conn = ConnectionManager.getConnection();
        String sql = "update user_info " +
                "set phone_number= ? ,email = ? ,birthday = ?" +
                "where username = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,phone_number);
            pstmt.setString(2,email);
            //将注册时间转换为SQL时间储存
            java.sql.Date sqlDate=new java.sql.Date(birthday.getTime());
            pstmt.setDate(3,sqlDate);
            pstmt.setString(4,username);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.closeConnection(conn);
        }
        //返回更新成功数量
        return count;
    }

    //通过uid查询用户状态
    @Override
    public int Find_User_type(int uid) {
        //默认状态为1
        int type = 1;
        //初始化数据库连接，sql语句
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT u_type from user_info where uid=?";
        try {
            //创建数据库语句预备对象
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,uid);
            ResultSet rs = pstmt.executeQuery();
            type = rs.getType();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.closeConnection(conn);
        }

        return type;
    }


    @Override
    public int Find_UUid_ByUname(String unmae) {
        int uuid = 0;
        Connection conn = ConnectionManager.getConnection();
        String sql = "select uid from user_info where username=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,unmae);
            ResultSet rs = pstmt.executeQuery();
            uuid=rs.getInt("uid");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.closeConnection(conn);
        }

        return uuid;
    }


    //
    @Override
    public int Del_User_Byusername(String username) {
        return 0;
    }

    @Override
    public int Del_User_ByUid(int uid) {
        return 0;
    }

    @Override
    public int User_Updata_password(String username, String password) {
        return 0;
    }

    @Override
    public User Find_Userinfo_ByUname(String username) {
        return null;
    }

    //通过用户uid 改变用户状态
    @Override
    public int UpdateUtype_ByUUid(int uid) {
        return 0;
    }

   /**
    * 功能:显示所有用户
    * @return  返回User集合
    * */
    @Override
    public List<User> Find_AllUser() {
        //初始化返回值
        List<User> list_User = new ArrayList<User>();
        //初始化数据库连接及数据库字段
        Connection conn = ConnectionManager.getConnection();
        String sql = "select * from user_info";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setUid(rs.getInt(rs.getInt("uid")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("brithday"));
                user.setPhonenumber(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                user.setU_type(rs.getInt("u_type"));
                user.setRegisttime(rs.getTimestamp("registr_date"));
                list_User.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionManager.closeConnection(conn);
        }


        return list_User;
    }
}
