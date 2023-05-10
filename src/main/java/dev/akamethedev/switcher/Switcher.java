package dev.akamethedev.switcher;

import dev.akamethedev.switcher.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import dev.akamethedev.switcher.handlers.dataHandler;

public final class Switcher extends JavaPlugin {
    public static Switcher INSTANCE;
    @Override
    public void onEnable() {
        INSTANCE = this;
        new dataHandler();
        getLogger().info("Loading commands..");
        this.getCommand("gamemode").setExecutor(new CommandGamemode());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("switcher").setExecutor(new CommandSwitcher());
        this.getCommand("heal").setExecutor(new CommandHeal());
        this.getCommand("tp").setExecutor(new CommandTp());
        this.getCommand("setspawn").setExecutor(new CommandSetspawn());
        this.getCommand("spawn").setExecutor(new CommandSpawn());
        getLogger().info("Commands successfully loaded");
        getLogger().info("Loading config...");
        getLogger().info("Config loaded");
        getLogger().info("The plugin is now enabled");
    }


    @Override
    public void onDisable() {
        getLogger().info("Unloading commands..");
        getLogger().info("Commands successfully unloaded");
        getLogger().info("The plugin is now disabled");
    }


}
