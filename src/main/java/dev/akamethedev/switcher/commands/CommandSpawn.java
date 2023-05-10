package dev.akamethedev.switcher.commands;

import dev.akamethedev.switcher.handlers.dataHandler;
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
                    System.out.println("x: " + o);
                    if (o instanceof Location) System.out.println("y: true");
                    player.teleport(location);
                }
            } else {
                sender.sendMessage("§cThis command can only be used in game.");

            }
        }
        return true;
    }
}


