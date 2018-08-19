package org.SCT.Level.Command;

import com.google.common.collect.Maps;

import org.SCT.Core.Core;
import org.SCT.Level.Language;
import org.SCT.Level.Command.SubCommand.AddCommand;
import org.SCT.Level.Command.SubCommand.HelpCommand;
import org.SCT.Level.Command.SubCommand.ReloadCommand;
import org.SCT.Level.Command.SubCommand.SetCommand;
import org.SCT.Level.Util.SubCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

/**
 * @author 莫仕 稍作修改
 */

public class CommandHandle implements CommandExecutor{
    private Map<String, SubCommand> subCommandMap = Maps.newHashMap();

    public CommandHandle() {
        registerSubCommand("help", new HelpCommand());
        registerSubCommand("set", new SetCommand());
        registerSubCommand("add", new AddCommand());
     //   registerSubCommand("take", new TakeCommand());
        //registerSubCommand("top", new TopCommand());

        registerSubCommand("reload", new ReloadCommand());
    }

    public void registerSubCommand(String commandName, SubCommand command) {
        if (subCommandMap.containsKey(commandName)) {
            Core.info("发现重复子命令注册!");
        }
        subCommandMap.put(commandName, command);
    }

    public void unregisterSubCommand(String commandName) {
        subCommandMap.remove(commandName);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("lp")) {
            if(args.length == 0) {
                if(!(sender instanceof Player)) {
                    subCommandMap.get("admin").execute(sender, args);
                    return true;
                }
                return true;
            }

            SubCommand subCommand = subCommandMap.get(args[0]);
            if (subCommand == null) {
                sender.sendMessage(Language.UnknownCommand);
                return true;
            }
            subCommand.execute(sender, args);
        }
        return false;
    }

}
