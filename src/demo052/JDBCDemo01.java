package demo052;

import cn.hutool.db.Db;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCDemo01 {
    @Test
    public void  TestUtil()throws Exception{

        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from a ";
        //where name  = ? and pwd = ?
        PreparedStatement stmt = conn.prepareStatement(sql);
        //需要设计参数
//        stmt.setString(1,"aaa");
//        stmt.setInt(2,123456);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("pwd"));
        }
        JDBCUtil.close(conn,stmt,rs);

    }


}
