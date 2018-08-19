package org.SCT.Level.Command.SubCommand;

import org.SCT.Level.Language;
import org.SCT.Level.Util.SubCommand;
import org.bukkit.command.CommandSender;

public class HelpCommand implements SubCommand {

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(sender.isOp()) sender.sendMessage(Language.PermDenied);
        
        /*
         * qwq嘤嘤嘤
         * 
         * sender.sendMessage("§c§m   §6§m   §e§m   §a§m   §b§m   §e§l&nSCT_Level指令§b§m   §a§m   §e§m   §6§m   §c§m   ");
         * sender.sendMessage("§7/level addlevel [数值] [玩家] §a增加某玩家的等级");
         * sender.sendMessage("§7/level takelevel [数值] [玩家] §a拿走某玩家的等级");
         * sender.sendMessage("§7/level addexp [数值] [玩家] §a增加某玩家的等级");
         * sender.sendMessage("§7/level takeexp [数值] [玩家] §a拿走某玩家的等级");
         * sender.sendMessage("§7/level setlevel [数值] [玩家] §a设置某玩家的等级");
         * sender.sendMessage("§7/level setexp [数值] [玩家] §a设置某玩家的经验");
         * sender.sendMessage("§7/level reload §a重载插件");
         * 
         */
        
        for(String Temp : Language.HelpMessage) {
        	sender.sendMessage(Temp.replace("&", "§"));
        }
        return true;
    }
}
