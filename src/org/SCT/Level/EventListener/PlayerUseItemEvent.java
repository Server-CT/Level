package org.SCT.Level.EventListener;

import org.SCT.Level.File.ConfigReader;
import org.SCT.Level.Util.ExpChangeUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerUseItemEvent implements Listener {

    public void onPlayerUseItem(PlayerInteractEvent e) {
        //获取该事件玩家
        Player player = e.getPlayer();
        //获取使用的道具
        ItemStack item = player.getItemInHand();
        //物品数量，方便减少
        int itemAmount = e.getItem().getAmount();
        int newAmount;
        int exp;
        int level;
        //如果发生了写奇奇怪怪的事情，返回
        if(e.isCancelled()) return;
        if(!e.hasItem()) return;
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if(ConfigReader.getLevelItem(item) == null || item == null || itemAmount <= 0) return;
        exp = ConfigReader.getItemExp(item);
        ExpChangeUtil.AddExp(player.getName(), exp, player);
        newAmount = itemAmount - 1;
        if(newAmount == 0) player.getInventory().remove(item);
        item.setAmount(newAmount);
    }
}
