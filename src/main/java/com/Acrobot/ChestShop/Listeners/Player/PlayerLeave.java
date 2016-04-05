package com.Acrobot.ChestShop.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.Acrobot.ChestShop.Commands.Toggle;

/**
 * @author KingFaris10
 */
public class PlayerLeave implements Listener {

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event) {
        if (Toggle.isIgnoring(event.getPlayer())) {
            Toggle.setIgnoring(event.getPlayer(), false);
        }
    }

}
