package Test.Dao;

import DB.Bean.News;
import DB.Bean.User;
import DB.Dao.DaoImpl.NewsDaoImpl;
import DB.Dao.DaoImpl.UserDaoImpl;
import DB.Dao.UserDao;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Test_UserDaoImpl {
    //测试用户注册页
    @Test
    public void Test_Regist(){
        UserDao t1=new UserDaoImpl();
        int t = 2;
        long tm = System.currentTimeMillis();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = "2017-11-20 21:32:11";
        java.util.Date date=null;
        try{
            date=sd.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Timestamp dateSQL = new Timestamp(date.getTime());
        int L1=t1.Regist("11111","111112",dateSQL);
        System.out.println(L1);
    }
    //测试用户登录
    @Test
    public void Test_Login(){
        UserDao t2=new UserDaoImpl();
        boolean L3=t2.Login("22222","222223");
        System.out.println(L3);
    }

    //测试添加用户信息
    @Test
    public void Test_Add_UserInfo(){
        UserDao t3=new UserDaoImpl();
        int t = 2;
        long tm = System.currentTimeMillis();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = "2019-1-20 21:32:11";
        java.util.Date date=null;
        try{
            date=sd.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Timestamp dateSQL = new Timestamp(date.getTime());
        int L3=t3.Add_UserInfo("11111","111112","1985064433@QQ.COM",dateSQL);
        System.out.println(L3);
    }

    //测试查询用户状态
    @Test
    public void Test_Find_User_type(){
        UserDao t4=new UserDaoImpl();
        int L4=t4.Find_User_type(1);
        System.out.println(L4);
    }

    //通过用户名查询用户UID
    @Test
    public void Test_Find_UUid_ByUname(){
        UserDao t5=new UserDaoImpl();
        int L5=t5.Find_UUid_ByUname("sad");
        System.out.println(L5);
    }

    //通过用户名删除用户
    @Test
    public void Test_Del_User_Byusername(){
        UserDao t6=new UserDaoImpl();
        int L6=t6.Del_User_Byusername("11111");
        System.out.println(L6);
    }

    //测试通过uid删除用户
    @Test
    public void Test_Del_User_ByUid(){
        UserDao t7=new UserDaoImpl();
        int L7=t7.Del_User_ByUid(8);
        System.out.println(L7);
    }
    //测试用户修改密码
    @Test
    public void Test_User_Updata_password(){
        UserDao t8=new UserDaoImpl();
        int L8=t8.User_Updata_password("11111","22222");
        System.out.println(L8);
    }
    //测试根据用户名查询用户资料
    @Test
    public void Test_Find_Userinfo_ByUname(){
        UserDao t9=new UserDaoImpl();
        User L9=t9.Find_Userinfo_ByUname("11111");
        System.out.println(L9.getBirthday()+"    "+L9.getEmail()+"     其他的就不看了");
    }
    //通过用户uid修改用户状态
    @Test
    public void Test_UpdateUtype_ByUUid(){
        UserDao t9=new UserDaoImpl();
        int L10=t9.UpdateUtype_ByUUid(9,2);
        System.out.println(L10);//0:普通用户，1:封禁状态，2：管理员
    }
    //测试显示所有用户
    @Test
    public void Test_Find_AllUser(){
        UserDao t10=new UserDaoImpl();
        List<User> L10=t10.Find_AllUser();
        for (int i = 0; i < L10.size(); i++){
            System.out.println(L10.get(i).getUsername());
        }
    }




}
