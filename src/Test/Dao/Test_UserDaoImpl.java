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
        boolean L3=t2.Login("11111","111112");
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

    //测试通过用户名查询用户UID
    @Test
    public void Test_Find_User_type(){
        UserDao t4=new UserDaoImpl();
        int L4=t4.Del_User_ByUid(1);
        System.out.println(L4);
    }





}
