package org.SCT.Level.EventListener;

import org.SCT.Level.File.ConfigReader;
import org.SCT.Level.Util.ExpChangeUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import sun.security.krb5.Config;


import java.util.ArrayList;
import java.util.List;

public class DeathEvent implements Listener {

    String entityName;
    EntityType type;
    String mobName;
    int exp;

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {

        //如果干掉了了怪物的是玩家
        if (e.getEntity().getKiller() instanceof Player) {

            entityName = e.getEntity().getKiller().getName();
            mobName = e.getEntity().getName();

            if (ConfigReader.isContainString(mobName)) {
                type = e.getEntityType();
                exp = ConfigReader.getMobExp(type, mobName);
                ExpChangeUtil.AddExp(entityName, exp, e.getEntity().getKiller());
            }
            return;
        }

    }
}
