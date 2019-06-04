package Util;

import Model.order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoTool {
    private static Connection connection = null;
    private static Statement statement = null;
    public DaoTool(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:HomeWork.db");
            statement = connection.createStatement();
            String SuperGroupTable = "CREATE TABLE IF NOT EXISTS 'bighomework'( ID INTEGER PRIMARY KEY   AUTOINCREMENT, orderType VARCHAR(100), orderMoney INTEGER, CreateTime DATETIME)";
            statement.executeUpdate(SuperGroupTable);
            statement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void AddData(String orderType,String ordermoney){
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sql = "INSERT INTO bighomework (orderType,orderMoney,CreateTime)values('"+orderType+"','"+ordermoney+"',datetime('now','localtime'))";
            statement.executeUpdate(sql);
            connection.commit();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<order> GetAllOrder(){
        ArrayList<order> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String GetSuperGroupSql = "select * from bighomework";
            ResultSet rs = statement.executeQuery(GetSuperGroupSql);
            while (rs.next()){
                int ID = rs.getInt("ID");
                String orderType = rs.getString("orderType");
                String orderMoney = rs.getString("orderMoney");
                String date = rs.getString("CreateTime");
                list.add(new order(ID,orderType,orderMoney,date));
            }
            rs.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
