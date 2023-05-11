package dev.ayame.versacore;

import dev.ayame.versacore.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import dev.ayame.versacore.handlers.dataHandler;

public final class VersaCore extends JavaPlugin {
    public static VersaCore INSTANCE;
    @Override
    public void onEnable() {
        INSTANCE = this;
        new dataHandler();
        getLogger().info("Loading commands..");
        this.getCommand("gamemode").setExecutor(new CommandGamemode());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("versacore").setExecutor(new CommandVersaCore());
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
