package dev.ayame.versacore.commands;

import dev.ayame.versacore.handlers.dataHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

public class CommandSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("spawn")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(!dataHandler.INSTANCE.locations.exists()) {
                    player.sendMessage("§cThe spawn is not set. Please set the spawn first using §b/setspawn");
                } else {
                    Location location = (Location) dataHandler.INSTANCE.getData("locations.spawn");
                    final Object o = dataHandler.INSTANCE.getData("locations.spawn");
                    player.teleport(location);
                    player.sendMessage("§fYou have been teleported to spawn");
                }
            } else {
                sender.sendMessage("§cThis command can only be used in game.");

            }
        }
        return true;
    }
}


