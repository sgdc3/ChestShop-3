package com.Acrobot.ChestShop.Database;

import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * A mapping for an account
 *
 * @author Andrzej Pomirski (Acrobot)
 */
@DatabaseTable(tableName = "players")
@DatabaseFileName("lastSeen.db")
public class PlayerName {

    @DatabaseField(canBeNull = false)
    private String fullName;

    @DatabaseField(id = true, canBeNull = false)
    private UUID uuid;

    public PlayerName() {
        // empty constructor, needed for ORMLite
    }

    public PlayerName(String fullName, UUID uuid) {
        this.fullName = fullName;
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
