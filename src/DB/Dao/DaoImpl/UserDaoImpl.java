package DB.Dao.DaoImpl;

import DB.Bean.User;
import DB.DBhelper.ConnectionManager;
import DB.Dao.UserDao;

import java.rmi.server.RemoteRef;
import java.sql.*;
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
    public int Add_UserInfo(String username, String password, String phone_number, String email, Date birthday) {
        int count = 1;
        return count;
    }

    @Override
    public int User_type(String username) {
        return 0;
    }

    @Override
    public int Find_UUid_ByUname(String unmae) {
        return 0;
    }

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

    @Override
    public int UpdateUtype_ByUUid(String uid) {
        return 0;
    }

    @Override
    public List<User> Find_AllUser() {
        return null;
    }
}
