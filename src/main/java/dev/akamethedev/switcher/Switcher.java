package dev.akamethedev.switcher;

import dev.akamethedev.switcher.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public final class Switcher extends JavaPlugin {
    private FileConfiguration config;
    public static Switcher INSTANCE;
    @Override
    public void onEnable() {
        INSTANCE = this;
        getLogger().info("Loading commands..");
        this.getCommand("gamemode").setExecutor(new CommandGamemode());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("switcher").setExecutor(new CommandSwitcher());
        this.getCommand("heal").setExecutor(new CommandHeal());
        this.getCommand("tp").setExecutor(new CommandTp());
        getLogger().info("Commands successfully loaded");

        getLogger().info("Loading config...");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getLogger().info("Config loaded");
        getLogger().info("The plugin is now enabled");
    }


    @Override
    public void onDisable() {
        getLogger().info("Unloading commands..");
        getLogger().info("Commands successfully unloaded");
        getLogger().info("The plugin is now disabled");
    }
    public void updateConfig() {
        reloadConfig();
        config = getConfig();
    }


}
