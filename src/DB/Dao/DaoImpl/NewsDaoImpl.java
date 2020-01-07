package DB.Dao.DaoImpl;


import DB.Bean.News;
import DB.DBhelper.ConnectionManager;
import DB.Dao.NewsDao;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Date 2020/1/2
 * 功能:实现新闻读取接口
 * */

public class NewsDaoImpl implements NewsDao {
    private int return_number = 0;

    /**
     * 功能:显示所有新闻
     * @return newslist 新闻对象集合 List<News>
     * */
    @Override
    public List<News> FindNews_All() {

        //声明新闻列表
        List<News> newslist = new ArrayList<News>();
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "select * from news_data";
        try {

            // 创建语句对象

            Statement stmt = conn.createStatement();

            // 执行SQL，返回结果集

            ResultSet rs = stmt.executeQuery(strSQL);


            // 遍历结果集
            while (rs.next()) {
                // 创建新闻实体


                News news = new News();

                // 设置实体属性
                news.setId(rs.getInt("id"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setNewshead(rs.getString("headlines"));
                news.setCount(rs.getInt("n_count"));
                news.setMaker(rs.getString("maker"));
                news.setNewstype(rs.getString("type"));
                news.setDetails(rs.getString("details"));;
                // 将实体添加到类别列表

                newslist.add(news);

            }

            // 关闭结果集

            rs.close();

            // 关闭语句对象

            stmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

        ConnectionManager.closeConnection(conn);

        }

        // 返回类别列表
        return newslist ;

    }


    /**
     * 功能:根据日期排序显示新闻
     * @return newslist 数新闻对象集合 List<News>
     * */
    @Override
    public List<News>  FindNews_ByDate() {
        //声明新闻列表
        List<News> newslist = new ArrayList<News>();
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "select * from news_data order by newstime" ;
        try {

            // 创建语句对象

            Statement stmt = conn.createStatement();

            // 执行SQL，返回结果集

            ResultSet rs = stmt.executeQuery(strSQL);

            // 遍历结果集

            while (rs.next()) {
                // 创建新闻实体
                News news = new News();

                // 设置实体属性
                news.setId(rs.getInt("id"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setNewshead(rs.getString("headlines"));
                news.setCount(rs.getInt("n_count"));
                news.setMaker(rs.getString("maker"));
                news.setNewstype(rs.getString("type"));
                news.setDetails(rs.getString("details"));
                // 将实体添加到类别列表

                newslist.add(news);

            }

            // 关闭结果集

            rs.close();

            // 关闭语句对象

            stmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        // 返回类别列表
        return newslist;
    }


    /**
     * 功能:根据类型显示新闻
     * @return newslist 新闻对象集合 List<News>
     * */
    @Override
    public List<News>  FindNews_ByType(String type) {
        //声明新闻列表
        List<News> newslist = new ArrayList<News>();
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "select * from news_data where type = ?" ;
        try {

            // 创建预备语句对象

            PreparedStatement psmt = conn.prepareStatement(strSQL);

            //为占位符赋值
            psmt.setString(1,type);

            //返回结果集

            ResultSet rs = psmt.executeQuery();

            // 遍历结果集

            while (rs.next()) {
                // 创建新闻实体
                News news = new News();

                // 设置实体属性
                news.setId(rs.getInt("id"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setNewshead(rs.getString("headlines"));
                news.setCount(rs.getInt("n_count"));
                news.setMaker(rs.getString("maker"));
                news.setNewstype(rs.getString("type"));
                news.setDetails(rs.getString("details"));
                // 将实体添加到类别列表

                newslist.add(news);

            }

            // 关闭结果集

            rs.close();

            // 关闭语句对象

            psmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        // 返回类别集合
        return newslist;
    }


    /**
     * 功能:根据阅读量显示新闻
     * @return newlist 新闻对象集合 List<News>
     * */
    @Override
    public List<News>  FindNews_ByCount(int max_count,int min_count) {
        //声明新闻列表
        List<News> newslist = new ArrayList<News>();
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "select * from news_data where n_count <= ? and n_count >= ?" ;
        try {

            // 创建预备语句对象

            PreparedStatement psmt = conn.prepareStatement(strSQL);

            //为占位符赋值
            psmt.setInt(1,max_count);
            psmt.setInt(2,min_count);

            // 返回结果集

            ResultSet rs = psmt.executeQuery();

            // 遍历结果集

            while (rs.next()) {
                // 创建新闻实体
                News news = new News();

                // 设置实体属性
                news.setId(rs.getInt("id"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setNewshead(rs.getString("headlines"));
                news.setCount(rs.getInt("n_count"));
                news.setMaker(rs.getString("maker"));
                news.setNewstype(rs.getString("type"));
                news.setDetails(rs.getString("details"));
                // 将实体添加到类别列表

                newslist.add(news);

            }

            // 关闭结果集

            rs.close();

            // 关闭语句对象

            psmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        // 返回类别列表
        return newslist;
    }


    /**
     * 功能:根据阅读量升序显示新闻
     * @return newlist 新闻对象集合 List<News>
     * */
    @Override
    public List<News>  FindNews_By_Count_Odascending() {
        //声明新闻列表
        List<News> newslist = new ArrayList<News>();
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "select * from news_data order by n_count";
        try {

            // 创建语句对象

            Statement stmt = conn.createStatement();

            // 执行SQL，返回结果集

            ResultSet rs = stmt.executeQuery(strSQL);


            // 遍历结果集
            while (rs.next()) {
                // 创建新闻实体


                News news = new News();

                // 设置实体属性
                news.setId(rs.getInt("id"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setNewshead(rs.getString("headlines"));
                news.setCount(rs.getInt("n_count"));
                news.setMaker(rs.getString("maker"));
                news.setNewstype(rs.getString("type"));
                news.setDetails(rs.getString("details"));;
                // 将实体添加到类别列表

                newslist.add(news);

            }

            // 关闭结果集

            rs.close();

            // 关闭语句对象

            stmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            ConnectionManager.closeConnection(conn);

        }

        // 返回新闻对象集合
        return newslist ;
    }


    /**
     * 功能:根据阅读量降序显示新闻
     * @return newlist 新闻对象集合 List<News>
     * */
    @Override
    public List<News>  FindNews_By_Count_Oddescending() {
        //声明新闻列表
        List<News> newslist = new ArrayList<News>();
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "select * from news_data order by n_count desc";
        try {

            // 创建语句对象

            Statement stmt = conn.createStatement();

            // 执行SQL，返回结果集

            ResultSet rs = stmt.executeQuery(strSQL);


            // 遍历结果集
            while (rs.next()) {
                // 创建新闻实体


                News news = new News();

                // 设置实体属性
                news.setId(rs.getInt("id"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setNewshead(rs.getString("headlines"));
                news.setCount(rs.getInt("n_count"));
                news.setMaker(rs.getString("maker"));
                news.setNewstype(rs.getString("type"));
                news.setDetails(rs.getString("details"));;
                // 将实体添加到类别列表

                newslist.add(news);

            }

            // 关闭结果集

            rs.close();

            // 关闭语句对象

            stmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            ConnectionManager.closeConnection(conn);

        }

        // 返回新闻对象集合
        return newslist ;
    }


    /**
     *功能:添加新闻
     * @return count 添加成功条数 int
     * */
    @Override
    public int Add_News(String headlines,String type, String details, String maker, Timestamp news_time,int uid) {
        //初始化插入条数
        int count = 0;
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "insert into news_data (headlines, type, newstime, maker, n_count, uid, details) values (?, ?, ?, ?, ?, ?, ?)";
        try {

            // 创建语句对象

            PreparedStatement psmt = conn.prepareStatement(strSQL);
            psmt.setString(1,headlines);
            psmt.setString(2,type);
            psmt.setTimestamp(3,news_time);
            psmt.setString(4,maker);
            psmt.setInt(5,count);
            psmt.setInt(6,uid);
            psmt.setString(7,details);


            // 返回插入条数
            count = psmt.executeUpdate();


            // 关闭语句对象

            psmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            ConnectionManager.closeConnection(conn);

        }

        // 返回插入条数
        return count;
    }


    /**
     *功能:根据ID删除新闻
     * @return count 删除成功条数 int
     * */
    @Override
    public int Del_News_ById(int id) {
        //初始化删除条数
        int count = 0;
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "delete from news_data where id = ?";
        try {

            // 创建语句对象

            PreparedStatement psmt = conn.prepareStatement(strSQL);
            psmt.setInt(1,id);

            // 返回插入条数
            count = psmt.executeUpdate();


            // 关闭语句对象

            psmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            ConnectionManager.closeConnection(conn);

        }

        // 返回删除行数
        return count;
    }


    /**
     *功能:根据UID删除新闻
     * @return count 删除成功条数 int
     * */
    @Override
    public int Del_News_ByUid(int uid) {
        //初始化删除条数
        int count = 0;
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "delete from news_data where id = ?";
        try {

            // 创建语句对象

            PreparedStatement psmt = conn.prepareStatement(strSQL);
            psmt.setInt(1,uid);

            // 返回插入条数
            count = psmt.executeUpdate();


            // 关闭语句对象

            psmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接

            ConnectionManager.closeConnection(conn);

        }
        return count;
    }


    /**
     *功能:返回所有的新闻种类
     * @return
     * */
    @Override
    public String[] Find_All_Type() {
        //创建返回集
        String[] err_arr = {};
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //判断方法是否异常结束，默认为true
        boolean is_err_over = true;
        //定义sql字符串
        String strSQL = "select type from news_data";
        try {

            Statement stmt = conn.createStatement();
            //声明储存新闻类型的集合
            ArrayList<String> list= new ArrayList<>();
            //执行SQL语句，返回结果集
            ResultSet rs = stmt.executeQuery(strSQL);
            //遍历结果集
            while (rs.next()) {
                String ty =  rs.getString("type");
                //结果添加进集合
                list.add(ty);
            }
            //集合转换为数组
            String[] arr_type = list.toArray(new String[list.size()]);
            is_err_over = false;
            ConnectionManager.closeConnection(conn);
            return arr_type;

        } catch (SQLException e) {
            e.printStackTrace();
            return err_arr;
        } catch (Exception e){
            System.out.println("服务器繁忙,错误原因:" + e.toString());
            e.printStackTrace();
            return err_arr;
        }finally {
            if (is_err_over){
                ConnectionManager.closeConnection(conn);
            }
        }
    }

    @Override
    public int[] FindNewsId_ByNewsNameUID(String newshead, int uid) {
        //创建返回ID
        int[] err_arr = {};
        //判断方法是否异常结束,默认为true
        boolean is_err_over = true;
        //创建数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //创建SQL语句
        String str_SQL = "select id from news_data where headlines = ? and uid = ?";

        try {
            //创建数据库预备对象
            PreparedStatement pstmt = conn.prepareStatement(str_SQL);
            //设置占位符值
            pstmt.setString(1,newshead);
            pstmt.setInt(2,uid);
            //返回结果集
            ResultSet rs = pstmt.executeQuery();
            //创建储存ID集合
            ArrayList<Integer> id_list = new ArrayList<>();
            //储存返回集ID
            while (rs.next()){
                int temp = rs.getInt("id");
                id_list.add(temp);
            }
            //转换为int数组
            int[] arr_id = new int[id_list.size()];
            for(int i = 0;i<id_list.size();i++){
                arr_id[i] = id_list.get(i);
            }
            ConnectionManager.closeConnection(conn);
            is_err_over = false;
            return arr_id;


        } catch (SQLException e) {
            e.printStackTrace();
            return err_arr;
        }finally {
            if (is_err_over){
                ConnectionManager.closeConnection(conn);
            }
        }

    }

    @Override
    public int FindNewsUid_ByNewsId(int id) {
        //初始化返回值
        int uid = 0;
        //创建数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL语句
        String strSQL = "select uid from news_data where id = ?";


        try {
            //创建数据库预备对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            //设置占位符值
            pstmt.setInt(1,id);
            //执行SQl查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                uid = rs.getInt("uid");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uid;

    }

    @Override
    public News FindNews_ById(int id) {
        //声明News对象
        News news = new News();
        //获取数据库连接
        Connection conn = ConnectionManager.getConnection();
        //SQL语句
        String sql = "select * from news_data where id = ?";
        //创建数据库查询预备对象
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //设置占位符值
            pstmt.setInt(1,id);
            //执行sql，返回结果集
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                news.setId(rs.getInt("id"));
                news.setNewshead(rs.getString("headlines"));
                news.setNewstype(rs.getString("type"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setMaker(rs.getString("maker"));
                news.setCount(rs.getInt("n_count"));
                news.setDetails(rs.getString("details"));
                news.setUid(rs.getInt("uid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public List<News> FindNews_ByUid(int uid) {
        //声明新闻列表
        List<News> newslist = new ArrayList<News>();
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        //定义SQL字符串
        String strSQL = "select * from news_data where uid = ?" ;
        try {

            // 创建预备语句对象

            PreparedStatement psmt = conn.prepareStatement(strSQL);

            //为占位符赋值
            psmt.setInt(1,uid);

            //返回结果集

            ResultSet rs = psmt.executeQuery();

            // 遍历结果集

            while (rs.next()) {
                // 创建新闻实体
                News news = new News();

                // 设置实体属性
                news.setId(rs.getInt("id"));
                news.setNewsdate(rs.getTimestamp("newstime"));
                news.setNewshead(rs.getString("headlines"));
                news.setCount(rs.getInt("n_count"));
                news.setMaker(rs.getString("maker"));
                news.setNewstype(rs.getString("type"));
                news.setDetails(rs.getString("details"));
                // 将实体添加到类别列表

                newslist.add(news);

            }

            // 关闭结果集

            rs.close();

            // 关闭语句对象

            psmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            // 关闭数据库连接
            ConnectionManager.closeConnection(conn);
            }



        // 返回类别集合
        return newslist;
    }

    @Override
    public int UpdataNews_ById(int id,String headlnes,String type,Timestamp newstime,String maker,int n_count,String details,int uid) {
        //初始化更新成功条数
        int count = 0;
        //定义SQl语句
        String sql = "update news_data " +
                "set headlines=?,type=?,newstime=?,maker=?,n_count=?,details=?,uid=?" +
                "where id = ?";
        //获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();

        try {
            //创建数据库语句预备对象
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,headlnes);
            pstmt.setString(2,type);
            pstmt.setTimestamp(3,newstime);
            pstmt.setString(4,maker);
            pstmt.setInt(5,n_count);
            pstmt.setString(6,details);
            pstmt.setInt(7,uid);
            pstmt.setInt(8,id);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        return count;
    }


    public int getReturn_number() {
        return return_number;
    }
}
