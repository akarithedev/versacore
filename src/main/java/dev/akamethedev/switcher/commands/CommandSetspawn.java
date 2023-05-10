package dev.akamethedev.switcher.commands;

import dev.akamethedev.switcher.Switcher;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.akamethedev.switcher.handlers.dataHandler;

public class CommandSetspawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("setspawn")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.getWorld().getName().equals("world")) {
                    dataHandler.INSTANCE.writeData("locations.spawn", player.getLocation());
                    player.sendMessage("§fThe spawn location has been set to your current location");
                } else {
                    player.sendMessage("§cYou can only set the spawn in overworld!");
                }
            } else {
                sender.sendMessage("§cThis command can only be used in game.");
            }
        }
        return true;
    }
}
