package it.servlet;

import java.sql.*;

public class Dbutils {

    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    /**
     * 获取连接对象
     *
     * @return
     */
    public Connection getConnection() {
        try {
            //1、加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接对象
            String url = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&characterEncoding=utf-8";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源
     *
     * @param conn
     * @param pstmt
     * @param rs
     */
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增删改操作
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object[] params) {
        this.getConnection();
        int result = 0;
        try {
            //3、创建preparedStatement对象
            pstmt = conn.prepareStatement(sql);
            //4、为占位符赋值
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            //5、调用方法：执行sql语句
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, null);
        }
        return result;
    }

    /**
     * 查询方法
     *
     * @param sql
     * @param params
     * @return
     */
    public ResultSet executeQuery(String sql, Object[] params) {
        this.getConnection();
        try {
            //3、创建preparedStatement对象
            pstmt = conn.prepareStatement(sql);
            //4、为占位符赋值
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            //5、调用方法：执行sql语句
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //后面具体的查询方法还需要用到rs ,所以此处最后不能关闭数据流
        return rs;
    }

}
