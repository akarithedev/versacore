package dev.akamethedev.switcher.commands;

import dev.akamethedev.switcher.Switcher;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import java.io.File;
public class CommandSpawn implements CommandExecutor {
    private FileConfiguration data;
    File locations = new File(Switcher.INSTANCE.getDataFolder().getPath(), "locations.yml");

    public Object getData(final String key) {
        if (data.isSet(key))
           return data.get(key);
        return null;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("spawn")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(!locations.exists()) {
                    player.sendMessage("§cThe spawn is not set. Please set the spawn first using §b/setspawn");
                } else {
                    Location location = (Location) getData("locations.spawn");
                    player.teleport(location);
                }
            } else {
                sender.sendMessage("§cThis command can only be used in game.");

            }
        }
        return true;
    }
}


