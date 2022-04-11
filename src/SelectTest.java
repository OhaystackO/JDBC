import java.sql.*;

public class SelectTest {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取链接
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","zyq123");
            //3.获取数据库操作对象
            stmt=conn.createStatement();
            //4.执行sql语句
            String sql="select ename,sal from emp";
            rs=stmt.executeQuery(sql);
            //5.处理查询结果集
            while(rs.next()){
                System.out.println(rs.getString("ename")+","+rs.getString("sal"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            //6.释放资源
            try{
               if(rs!=null){
                   rs.close();
               }
            }catch(SQLException e){
                e.printStackTrace();
            }
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
