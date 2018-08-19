package org.SCT.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.SCT.Core.Util.ActionBarUtil;
public class Schedule {
    public void start() {

        org.SCT.Level.Variable var = new org.SCT.Level.Variable();

        if(!(var.getMypetExists())){
            new BukkitRunnable(){
                @Override
                public void run(){
                    for(Player alchemy: Bukkit.getOnlinePlayers()){
                        ActionBarUtil.sendActionBar(alchemy,"血量:"+alchemy.getHealth());
                    }
                }
            }.runTaskTimer(Level.getPlugin(Level.class), 0L, org.SCT.Level.Variable.timer);
        }
    }

}
