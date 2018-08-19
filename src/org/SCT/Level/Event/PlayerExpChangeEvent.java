package org.SCT.Level.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerExpChangeEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final String oldExp;
    private final String newExp;
    private boolean cancle;

    public PlayerExpChangeEvent(Player player, String oldExp, String newExp) {
        this.oldExp = oldExp;
        this.newExp = newExp;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public boolean isCancelled() { return this.cancle; }

    public void setCancelled(boolean cancel) { this.cancle = cancel; }

}
