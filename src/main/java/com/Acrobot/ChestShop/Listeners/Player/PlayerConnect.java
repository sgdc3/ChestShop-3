package com.Acrobot.ChestShop.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Acrobot.ChestShop.UUIDs.NameManager;

/**
 * @author Acrobot
 */
public class PlayerConnect implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public static void onPlayerConnect(final PlayerJoinEvent event) {
        NameManager.storeUsername(event.getPlayer());
    }
}
