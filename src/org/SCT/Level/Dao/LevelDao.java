package org.SCT.Level.Dao;

public interface LevelDao {

    //返回玩家等级
    int getPlayerLevel(String player);
    //返回玩家经验
    double getPlayerExp(String player);
    //设置玩家等级
    void setPlayerLevel(String player, int level);
    //设置玩家经验
    void setPlayerExp(String player, double exp);
    //是否有数据
    boolean hasData(String player);


}
