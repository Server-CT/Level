package org.SCT.Level.Command.SubCommand;

import org.SCT.Level.Language;
import org.SCT.Level.Level;
import org.SCT.Level.Dao.ServiceDao;
import org.SCT.Level.Util.ExpChangeUtil;
import org.SCT.Level.Util.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddCommand implements SubCommand {

    @Override
    //addlevel 数值 玩家
    public boolean execute(CommandSender sender, String[] args) {
        if(args.length != 3) {
            sender.sendMessage(Language.ErrorParam);
            return false;
        }

        // || (sender instanceof Player && sender.hasPermission("SCTLevel.add"))
        if(!sender.isOp()) {
            sender.sendMessage(Language.PermDenied);
            return false;
        }

        if(ServiceDao.playerHasData(args[2]) && args[0].startsWith("addlevel")) {
            ServiceDao.addPlayerLevel(args[2], args[1]);
            sender.sendMessage(Language.AddLevel.replace("%Player%", args[2]).replace("%Level%", args[1]));
        }

        if(ServiceDao.playerHasData(args[2]) && args[0].startsWith("addexp")) {
        	Player p = Level.getInstance().getServer().getPlayer(args[2]);
        	
            ExpChangeUtil.AddExp(args[2], Integer.parseInt(args[1]), p);
            sender.sendMessage(Language.AddExp.replace("%Player%", args[2]).replace("%Exp%", args[1]));
        }
        return true;
    }
}
