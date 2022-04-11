import java.sql.*;
import java.util.ResourceBundle;

/*
JDBC编程六部
    1.注册驱动
    2.获取链接
    3.创建数据库操作对象
    4.执行Sql语句
    5.处理查询结果集
    6.释放资源
*/
public class InsertTest {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        //通过资源绑定器从属性配置文件中获取信息，更灵活
        ResourceBundle bundle=ResourceBundle.getBundle("JDBC");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String pw=bundle.getString("pw");
        try {
            //1.注册驱动
            Class.forName(driver);//利用反射机制加载类，利用加载类会执行静态代码块的特性加载Driver源码中的静态代码块注册驱动
            //2.获取链接
            conn=DriverManager.getConnection(url,user,pw);
            //3.创建数据库操作对象
            stmt=conn.createStatement();
            //4.执行sql语句
            String sql=bundle.getString("insert");
            int count=stmt.executeUpdate(sql);
            System.out.println(count==1?"操作成功":"操作失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
