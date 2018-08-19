package org.SCT.Level.Command.SubCommand;

import org.SCT.Level.Language;
import org.SCT.Level.Level;
import org.SCT.Level.Util.SubCommand;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements SubCommand {

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(args.length != 1) {
            sender.sendMessage(Language.ErrorParam);
            return true;
        }
        if(!sender.isOp()) {
            sender.sendMessage(Language.PermDenied);
            return true;
        }
        Level.getInstance().reloadConfig();
        sender.sendMessage(Language.ReloadSuccess);
        return false;
    }
}
