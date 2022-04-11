import java.sql.*;
import java.util.ResourceBundle;

public class UpdateTest {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResourceBundle bundle=ResourceBundle.getBundle("JDBC");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String pw=bundle.getString("pw");
        try{
            //1.注册驱动
            Class.forName(driver);
            //2.获取链接
            conn=DriverManager.getConnection(url,user,pw);
            //3.创建数据库操作对象
            stmt=conn.createStatement();
            //4.执行sql语句
            String sql="update dept set deptno=50,dname='PEOPLEMGR',loc='BEIJING' where deptno=50";
            int res=stmt.executeUpdate(sql);
            System.out.println(res==1?"操作成功":"操作失败");
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try{
                if(stmt!=null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
