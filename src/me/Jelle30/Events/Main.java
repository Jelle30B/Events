package me.Jelle30.Events;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable()  {
        new PlayerListner(this);
        getLogger().info("Plugin Events loaded!");
    }

    public void onDisable() {

    }
}
