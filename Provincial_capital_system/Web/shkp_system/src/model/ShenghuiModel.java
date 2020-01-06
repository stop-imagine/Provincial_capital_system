package model;

import entity.ShengHui;
import java.sql.*;

public class ShenghuiModel {
    //JDBC连接
    private static String driverName="com.mysql.cj.jdbc.Driver";
    private static String userName="root";
    private static String userPwd="12345678";
    private static String dbName="kepu";
    private static String url2="jdbc:mysql://localhost:3306/"+dbName;
    private static String url3="?user="+userName+"&password="+userPwd;
    private static String url4="&useUnicode=true&characterEncoding=UTF-8";
    private static String url=url2+url3+url4;

    public static ShengHui getShenghuis(String id){
        Connection con = null;
        PreparedStatement pstmt = null;     //定义PreparedStatement对象
        ResultSet rs = null;        //定义一个结果集
        ShengHui sh = new ShengHui();
        try {
            Class.forName(driverName);     //加载并注册驱动程序
            con= DriverManager.getConnection(url);      //创建连接对象
            pstmt = con.prepareStatement("SELECT * FROM shenghui WHERE id=?");
            pstmt.setString(1,id);    //设置第一个参数值
            rs = pstmt.executeQuery();
            if (rs.next()){
                sh.setId(rs.getInt(1));
                sh.setShengming(rs.getString(2));
                sh.setHuiming(rs.getString(3));
                sh.setMeishi(rs.getString(4));
                sh.setJingdian(rs.getString(5));
                sh.setGaoxiao(rs.getString(6));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                //释放资源 反序释放
                if (rs!=null){
                    rs.close();     //关闭查询结果集对象
                }
                if (pstmt!=null){
                    pstmt.close();  //关闭操作对象
                }
                if (con!=null){
                    con.close();    //关闭数据库连接对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sh;
    }

    public static ShengHui getSelectRs(String shengming){
        Connection con = null;
        PreparedStatement pstmt = null;     //定义PreparedStatement对象
        ResultSet rs = null;        //定义一个结果集
        ShengHui coun = new ShengHui();
        try {
            Class.forName(driverName);     //加载并注册驱动程序
            con= DriverManager.getConnection(url);      //创建连接对象
            pstmt = con.prepareStatement("SELECT * FROM shenghui WHERE shengming =?");
            pstmt.setString(1,shengming);    //设置第一个参数值
            rs = pstmt.executeQuery();
            if (rs.next()){
                coun.setId(rs.getInt(1));
                coun.setShengming(rs.getString(2));
                coun.setHuiming(rs.getString(3));
                coun.setMeishi(rs.getString(4));
                coun.setJingdian(rs.getString(5));
                coun.setGaoxiao(rs.getString(6));
            }
            else {
                coun.setHuiming(shengming);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                //释放资源 反序释放
                if (rs!=null){
                    rs.close();     //关闭查询结果集对象
                }
                if (pstmt!=null){
                    pstmt.close();  //关闭操作对象
                }
                if (con!=null){
                    con.close();    //关闭数据库连接对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return coun;
    }

    public static boolean addRs(String shengming, String huiming, String meishi, String jingdian, String gaoxiao){
        boolean res = false;
        Connection con = null;
        PreparedStatement pstmt = null;     //定义PreparedStatement对象
        ResultSet rs = null;        //定义一个结果集
        int count = 0;
        try {
            Class.forName(driverName);     //加载并注册驱动程序
            con= DriverManager.getConnection(url);      //创建连接对象
            pstmt = con.prepareStatement("INSERT INTO shenghui(shengming,huiming,meishi,jingdian,gaoxiao) VALUES(?,?,?,?,?)");
            pstmt.setString(1,shengming);    //设置第一个参数值
            pstmt.setString(2,huiming);    //设置第一个参数值
            pstmt.setString(3,meishi);    //设置第一个参数值
            pstmt.setString(4,jingdian);    //设置第一个参数值
            pstmt.setString(5,gaoxiao);    //设置第一个参数值
            count = pstmt.executeUpdate();
            if (count == 1) res = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                //释放资源 反序释放
                if (rs!=null){
                    rs.close();     //关闭查询结果集对象
                }
                if (pstmt!=null){
                    pstmt.close();  //关闭操作对象
                }
                if (con!=null){
                    con.close();    //关闭数据库连接对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static boolean updateRs(String shengming, String huiming, String meishi, String jingdian, String gaoxiao){
        boolean res = false;
        Connection con = null;
        PreparedStatement pstmt = null;     //定义PreparedStatement对象
        ResultSet rs = null;        //定义一个结果集
        int count = 0;
        try {
            Class.forName(driverName);     //加载并注册驱动程序
            con= DriverManager.getConnection(url);      //创建连接对象
            pstmt = con.prepareStatement("UPDATE shenghui SET shengming=?,huiming=?,meishi=?,jingdian=?,gaoxiao=? WHERE shengming=?");
            pstmt.setString(1,shengming);
            pstmt.setString(2,huiming);
            pstmt.setString(3,meishi);
            pstmt.setString(4,jingdian);
            pstmt.setString(5,gaoxiao);
            pstmt.setString(6,shengming);

            count = pstmt.executeUpdate();
            if (count == 1) res = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                //释放资源 反序释放
                if (rs!=null){
                    rs.close();     //关闭查询结果集对象
                }
                if (pstmt!=null){
                    pstmt.close();  //关闭操作对象
                }
                if (con!=null){
                    con.close();    //关闭数据库连接对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static boolean deleteRs(String str){
        boolean res = false;
        Connection con = null;
        PreparedStatement pstmt = null;     //定义PreparedStatement对象
        ResultSet rs = null;        //定义一个结果集
        int count = 0;
        try {
            Class.forName(driverName);     //加载并注册驱动程序
            con= DriverManager.getConnection(url);      //创建连接对象
            pstmt = con.prepareStatement("DELETE FROM shenghui WHERE shengming=?");
            pstmt.setString(1,str);
            count = pstmt.executeUpdate();
            if (count == 1)res = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                //释放资源 反序释放
                if (rs!=null){
                    rs.close();     //关闭查询结果集对象
                }
                if (pstmt!=null){
                    pstmt.close();  //关闭操作对象
                }
                if (con!=null){
                    con.close();    //关闭数据库连接对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

}
