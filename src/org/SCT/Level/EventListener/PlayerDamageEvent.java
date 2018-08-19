package org.SCT.Level.EventListener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerDamageEvent implements Listener{

    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        //如果发生一些奇奇怪怪的事情，返回
        if(e.isCancelled()) return;
        if(!e.getEntity().equals(EntityType.PLAYER)) return;
        //初始伤害
        double initialDamage = e.getDamage();
        //强转damager为玩家
        Player player = (Player) e.getDamager();


    }
}
