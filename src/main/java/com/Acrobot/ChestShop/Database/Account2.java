package com.Acrobot.ChestShop.Database;

import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * A mapping for an account
 *
 * @author Andrzej Pomirski (Acrobot)
 */
@DatabaseTable(tableName = "accounts")
@DatabaseFileName("usersv2.db")
public class Account2 {

    @DatabaseField(id = true, canBeNull = false)
    private String shortName;

    @DatabaseField(canBeNull = false)
    private UUID uuid;

    public Account2() {
        // empty constructor, needed for ORMLite
    }

    public Account2(String shortName, UUID uuid) {
        this.shortName = shortName;
        this.uuid = uuid;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
