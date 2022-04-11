import java.sql.*;
import java.util.ResourceBundle;

public class DeleteTest {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        //资源绑定器获取信息
        ResourceBundle bundle=ResourceBundle.getBundle("JDBC");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String pw=bundle.getString("pw");
        try {
            //1.注册驱动
           Class.forName(driver);
            //2.获取链接
            conn=DriverManager.getConnection(url,user,pw);
            //3.创建数据库操作对象
            stmt=conn.createStatement();
            //4.执行sql语句
            String sql= "delete from dept where deptno=60";//编辑sql语句
            int count=stmt.executeUpdate(sql);//通过数据库操作对象执行sql语句
            System.out.println(count==1?"操作成功":"操作失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{//6.释放资源，先开的后关，后开的先关
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
