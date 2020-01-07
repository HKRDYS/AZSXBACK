package DB.Dao;



import DB.Bean.User;

import java.util.Date;
import java.util.List;

public interface UserDao {
    //用户注册
    int Regist(String username, String password, Date registrdate);
    //用户登录
    boolean Login(String username, String password);
    //用户添加自己的信息
    int Add_UserInfo(String username, String phone_number, String email, Date birthday);


    /**
     * 功能:查询用户状态
     * 返回: 0:普通用户，1:封禁状态，2：管理员
     * @return type
     * */
    int Find_User_type(int uid);
    //通过用户名查询用户UID
    int Find_UUid_ByUname(String unmae);
    //通过用户名删除用户
    int Del_User_Byusername(String username);
    //通过uid删除用户
    int Del_User_ByUid(int uid);

    //用户修改密码
    int User_Updata_password(String username, String password);
    //根据用户名查询用户资料
    User Find_Userinfo_ByUname(String username);
    //通过用户uid修改用户状态
    int UpdateUtype_ByUUid(int uid,int u_type);
    //显示所有用户
    List<User> Find_AllUser();
}
