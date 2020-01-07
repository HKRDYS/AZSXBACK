package DB.server;

import DB.Bean.User;
import DB.Dao.DaoImpl.UserDaoImpl;

import java.util.Date;
import java.util.List;

public class UserServer extends UserDaoImpl {
    @Override
    public int Regist(String username, String password, Date registrdate) {
        return super.Regist(username, password, registrdate);
    }

    @Override
    public boolean Login(String username, String password) {
        return super.Login(username, password);
    }

    @Override
    public int Add_UserInfo(String username, String phone_number, String email, Date birthday) {
        return super.Add_UserInfo(username, phone_number, email, birthday);
    }

    @Override
    public int Find_User_type(int uid) {
        return super.Find_User_type(uid);
    }

    @Override
    public int Find_UUid_ByUname(String unmae) {
        return super.Find_UUid_ByUname(unmae);
    }

    @Override
    public int Del_User_Byusername(String username) {
        return super.Del_User_Byusername(username);
    }

    @Override
    public int Del_User_ByUid(int uid) {
        return super.Del_User_ByUid(uid);
    }

    @Override
    public int User_Updata_password(String username, String password) {
        return super.User_Updata_password(username, password);
    }

    @Override
    public User Find_Userinfo_ByUname(String username) {
        return super.Find_Userinfo_ByUname(username);
    }

    @Override
    public int UpdateUtype_ByUUid(int uid, int u_type) {
        return super.UpdateUtype_ByUUid(uid, u_type);
    }

    @Override
    public List<User> Find_AllUser() {
        return super.Find_AllUser();
    }
}
