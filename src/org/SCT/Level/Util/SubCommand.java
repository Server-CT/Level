package org.SCT.Level.Util;

import org.bukkit.command.CommandSender;

public interface SubCommand {
    public abstract boolean execute(CommandSender sender, String[] args);
}
