package org.SCT.Level.Command.SubCommand;

import org.SCT.Level.Language;
import org.SCT.Level.Dao.ServiceDao;
import org.SCT.Level.Util.SubCommand;
import org.bukkit.command.CommandSender;

public class SetCommand implements SubCommand {

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(sender.isOp()) sender.sendMessage(Language.PermDenied);
        if(args.length != 3) sender.sendMessage(Language.ErrorParam);

        if(ServiceDao.playerHasData(args[2]) && args[0].startsWith("setlevel")) {
            ServiceDao.setPlayerLevel(args[2], Integer.parseInt(args[1]));
            sender.sendMessage("§a成功将 §6§l" + args[2] + " §a等级设置为 §6§l" + args[1] + " §a级");
        }

        if(ServiceDao.playerHasData(args[2]) && args[0].startsWith("setexp")) {
            ServiceDao.setPlayerExp(args[2], Integer.parseInt(args[1]));
            sender.sendMessage("§a成功将 §6§l" + args[2] + " §a经验设置为 §6§l" + args[1] + " §a点");
        }

        if(ServiceDao.playerHasData(args[2]) && args[0].startsWith("addhealth")) {
            ServiceDao.setPlayerExp(args[2], Integer.parseInt(args[1]));
            sender.sendMessage("§a成功将 §6§l" + args[2] + " §a血量设置为 §6§l" + args[1] + " §a点");
        }
        return true;
    }
}
