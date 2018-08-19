package org.SCT.Level.EventListener;

import org.SCT.Level.Level;
import org.bukkit.event.Listener;

public class ListenerManager {
    private ListenerManager(){
        throw new NullPointerException("");
    }

    public static void registerListeners(){
        register(new PlayerDamageEvent());
        register(new PlayerUseItemEvent());
        register(new DeathEvent());
    }
    private static void register(Listener listener){
        Level.INSTANCE.getServer().getPluginManager().registerEvents(listener, Level.INSTANCE);
    }
}
