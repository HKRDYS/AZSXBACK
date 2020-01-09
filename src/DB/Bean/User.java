package DB.Bean;

import java.util.Date;

/**
 *日期:2019/12/31
 * 功能:用户信息实体类
 * */
public class User {
    //用户id
    private int uid;
    //用户名
    private String username;
    //用户密码
    private String password;
    //用户生日
    private Date birthday ;
    //用户邮箱
    private String email;
    //用户电话号码
    private String phonenumber;
    //用户状态
    private int u_type;
    //用户注册日期
    private Date registtime;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getU_type() {
        return u_type;
    }

    public void setU_type(int u_type) {
        this.u_type = u_type;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

}

