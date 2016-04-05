package com.Acrobot.ChestShop.Listeners.Economy;

import static com.Acrobot.ChestShop.Configuration.Properties.SERVER_ECONOMY_ACCOUNT;

import java.math.BigDecimal;
import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Acrobot.ChestShop.ChestShop;
import com.Acrobot.ChestShop.Events.Economy.CurrencyAddEvent;
import com.Acrobot.ChestShop.Events.Economy.CurrencyAmountEvent;
import com.Acrobot.ChestShop.Events.Economy.CurrencyCheckEvent;
import com.Acrobot.ChestShop.Events.Economy.CurrencyHoldEvent;
import com.Acrobot.ChestShop.Events.Economy.CurrencySubtractEvent;
import com.Acrobot.ChestShop.UUIDs.NameManager;

/**
 * @author Acrobot
 */
public class ServerAccountCorrector implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public static void onCurrencyAdd(CurrencyAddEvent event) {
        UUID target = event.getTarget();

        if (!NameManager.isAdminShop(target) || NameManager.isServerAccount(target)) {
            return;
        }

        if (SERVER_ECONOMY_ACCOUNT.isEmpty()) {
            event.setAdded(true);
            return;
        } else {
            target = NameManager.getServerAccountUUID();
        }

        event.setAdded(true);

        CurrencyAddEvent currencyAddEvent = new CurrencyAddEvent(event.getAmount(), target, event.getWorld());
        ChestShop.callEvent(currencyAddEvent);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public static void onCurrencySubtract(CurrencySubtractEvent event) {
        UUID target = event.getTarget();

        if (!NameManager.isAdminShop(target) || NameManager.isServerAccount(target)) {
            return;
        }

        if (SERVER_ECONOMY_ACCOUNT.isEmpty()) {
            event.setSubtracted(true);
            return;
        } else {
            target = NameManager.getServerAccountUUID();
        }

        event.setSubtracted(true);

        CurrencySubtractEvent currencySubtractEvent = new CurrencySubtractEvent(event.getAmount(), target, event.getWorld());
        ChestShop.callEvent(currencySubtractEvent);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public static void onCurrencyCheck(CurrencyCheckEvent event) {
        UUID target = event.getAccount();

        if (!NameManager.isAdminShop(target) || NameManager.isServerAccount(target)) {
            return;
        }

        if (SERVER_ECONOMY_ACCOUNT.isEmpty()) {
            event.hasEnough(true);
            return;
        } else {
            target = NameManager.getServerAccountUUID();
        }

        CurrencyCheckEvent currencyCheckEvent = new CurrencyCheckEvent(event.getAmount(), target, event.getWorld());
        ChestShop.callEvent(currencyCheckEvent);

        event.hasEnough(currencyCheckEvent.hasEnough());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public static void onCurrencyHoldCheck(CurrencyHoldEvent event) {
        UUID target = event.getAccount();

        if (!NameManager.isAdminShop(target) || NameManager.isServerAccount(target)) {
            return;
        }

        event.canHold(true);
        event.setAccount(null);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public static void onBalanceCheck(CurrencyAmountEvent event) {
        UUID target = event.getAccount();

        if (!NameManager.isAdminShop(target) || NameManager.isServerAccount(target)) {
            return;
        }

        if (SERVER_ECONOMY_ACCOUNT.isEmpty()) {
            event.setAmount(BigDecimal.valueOf(Double.MAX_VALUE));
            return;
        } else {
            target = NameManager.getServerAccountUUID();
        }

        CurrencyAmountEvent currencyAmountEvent = new CurrencyAmountEvent(target, event.getWorld());
        ChestShop.callEvent(currencyAmountEvent);

        event.setAmount(currencyAmountEvent.getAmount());
    }
}
