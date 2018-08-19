package org.SCT.Level.Dao;

public class ServiceDaoImpl implements LevelDao{

    @Override
    public int getPlayerLevel(String player) {
        if(player == null || player.equalsIgnoreCase(" ")) return 0;

        return 1;
    }

    @Override
    public double getPlayerExp(String player) {
        return 1.0;
    }

    @Override
    public void setPlayerLevel(String player, int level) {}

    @Override
    public void setPlayerExp(String player, double exp) {}

    @Override
    public boolean hasData(String player) {
        return true;
    }

}
