package org.SCT.Level.Dao;

import org.SCT.Core.MySQL.Dao.BasicDao;
import org.SCT.Core.MySQL.Util;
import org.SCT.Level.DataStorage.Storage;
import org.SCT.Level.Language;
import org.SCT.Level.Level;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServiceDao {

    static String TABLE_NAME = Level.INSTANCE.getConfig().getString("Mysql.TableName");

    //初始化玩家数据
    public static void initData(String name) {
        Connection connection = null;
        PreparedStatement ps = null;
        int id = 0;
        //id,name,exp,health
        String sql = "INSERT INTO " + TABLE_NAME + " VALUES(0, name, 1, 0)";

        try {
            connection = BasicDao.getConnection();
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            Language.sendError(e);
        }
    }

    public static boolean playerHasData(String name) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT Name FROM " + TABLE_NAME + " WHERE Name = '" + name + "'";

        try {
            connection = BasicDao.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
        	Language.sendError(e);
        }
        return false;
    }

    public static void addPlayerExp(String name, String amount) {
        String sql = "UPDATE " + TABLE_NAME + " SET Exp = Exp + " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);
    }

    public static void addPlayerLevel(String name, String amount) {
        String sql = "UPDATE " + TABLE_NAME + " SET Level = Level + " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);
    }

    public static void addPlayerHealth(String name, String amount) {
        String sql = "UPDATE " + TABLE_NAME + " SET Health = Health + " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);
    }


    public static void removePlayerExp(String name, String amount) {
        String sql = "UPDATE " + TABLE_NAME + " SET Exp = Exp - " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);
    }

    public static void removePlayerLevel(String name, String amount) {
        String sql = "UPDATE " + TABLE_NAME + " SET Level = Level - " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);
    }

    public static void removePlayerHealth(String name, String amount) {
        String sql = "UPDATE " + TABLE_NAME + " SET Health = Health - " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);
    }

    public static int getPlayerLevel(String name) {
        int result = 0;
        String sql = "SELECT Level FROM " + TABLE_NAME +" WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.getIntFromSql(sql);
        result = org.SCT.Core.MySQL.Util.getIntFromSql(sql);
        return result;
    }

    public static int getPlayerExp(String name) {
        int result = 0;
        String sql = "SELECT Exp FROM " + TABLE_NAME +" WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.getIntFromSql(sql);
        result = org.SCT.Core.MySQL.Util.getIntFromSql(sql);
        return result;
    }

    public static double getPlayerHealth(String name) {
        double result = 0.0;
        String sql = "SELECT Health FROM " + TABLE_NAME +" WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.getDoubleFromSql(sql);
        result = org.SCT.Core.MySQL.Util.getDoubleFromSql(sql);
        return result;
    }

    public static void setPlayerHealth(String name, int amount) {
        String result = null;
        String sql = "UPDATE Level SET Health = " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);

    }

    public static void setPlayerLevel(String name, int amount) {
        String result = null;
        String sql = "UPDATE Level SET Level = " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);

    }

    public static void setPlayerExp(String name, int amount) {
        String result = null;
        String sql = "UPDATE Level SET Exp = " + amount + " WHERE Name = '" + name + "'";
        org.SCT.Core.MySQL.Util.normalConnect(sql);

    }

}
