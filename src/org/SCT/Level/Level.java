package org.SCT.Level;

import org.SCT.Core.MySQL.Dao.BasicDao;
import org.SCT.Level.Command.CommandHandle;
import org.SCT.Level.EventListener.ListenerManager;
import org.SCT.Level.File.ConfigReader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Level extends JavaPlugin {
	
	public static String PLUGIN_VERSION = "1.4";
	
	String[] EnableMessage = {
    		"&7########################################",
    		"",
    		"&6SCT Level &9>",
    		"  &7由Server CT小组共同开发",
    		"  &7Server CT全家桶计划项目",
    		"  &7版本: &c" + PLUGIN_VERSION,
    		"",
    		"&7########################################"
    	};

    public static Level INSTANCE;
    public Connection connection;

    public void onEnable() {
    	
    	INSTANCE = this;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String host = getConfig().getString("Mysql.Host");
            String port = getConfig().getString("Mysql.Port");
            String dbname = getConfig().getString("Mysql.DataBase");
            String username = getConfig().getString("Mysql.User");
            String password = getConfig().getString("Mysql.Password");
            String tablename = getConfig().getString("Mysql.TableName");
            String ip = "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?autoReconnect=true";
            
            String sql = "CREATE TABLE IF NOT EXISTS '" + tablename + "' (" +
                    "'id' int(11) NOT NULL AUTO_INCREMENT," +
                    "'Name' varchar(255) DEFAULT NULL," +
                    "'Level' int(11) NOT NULL," +
                    "'Exp' double(12,2) DEFAULT NULL," +
                    "'Health' double(12,2) DEFAULT NULL," +
                    "PRIMARY KEY('id') ) " +
                    "ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ;";
            
            String SQL = "create table if not exists '" + tablename +
            "' (" +
              "'id' int(4) NOT NULL AUTO_INCREMENT," +
              "'Name' varchar(255) DEFAULT NULL," +
              "'Level' int(11) NOT NULL," + 
              "'Exp' double(12,2) DEFAULT NULL," + 
              "'Health' double(12,2) DEFAULT NULL," + 
              "PRIMARY KEY ('id')" + 
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ;";
            
            System.out.print(SQL);

            connection = DriverManager.getConnection(ip, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
            BasicDao.setConnection(connection);
            
            for(String Temp : EnableMessage) {
            	Bukkit.getServer().getConsoleSender().sendMessage(Temp.replace("&", "§"));
            }
        } catch (ClassNotFoundException e) {
            Language.sendError(e);
        } catch (SQLException e) {
        	Language.sendError(e);
        }

        ConfigReader.reload();
        Bukkit.getPluginCommand("level").setExecutor(new CommandHandle());
        ListenerManager.registerListeners();

        //Check MyPet
        for (Plugin i : Bukkit.getPluginManager().getPlugins()) {
            if (i.getName() == "MyPet") {
                Variable var = new Variable();
                var.setMypetExists(true);
                
                Bukkit.getServer().getConsoleSender().sendMessage(Language.MyPetEnable);
            }
        }
        Schedule sch = new Schedule();
        sch.start();

       // PlayerExpChangeEvent pece = new PlayerExpChangeEvent();
    }

    public void onDisable() {
    	if(connection != null) {
    		if (!BasicDao.isClose()) {
    			try{
    				BasicDao.close();
    			} catch(Exception e) {
    				Language.sendError(e);
    			}
           }
    	}
        Bukkit.getConsoleSender().sendMessage(Language.DisableMessage);
    }
    
    public static Level getInstance() {
        return INSTANCE;
    }
    
    public boolean isClose(Connection connection) {
        try {
            return connection.isClosed();
        } catch (SQLException e) {
        	e.printStackTrace();
            return false;
        }
    }
}
