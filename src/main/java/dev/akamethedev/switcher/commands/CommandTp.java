package dev.akamethedev.switcher.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.*;
import org.bukkit.Location;
public class CommandTp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tp")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length == 1) {
                    Player player2 = (Player) getPlayer(args[0]);
                    if(player2 == null) {
                        player.sendMessage("§cThe player is not online");
                    } else {
                        Location currentlocation = player.getLocation();
                        Location playerlocation = player2.getLocation();
                        if(currentlocation != playerlocation) {
                            player.teleport(new Location(getWorld("world"), playerlocation.getX(), playerlocation.getY(), playerlocation.getZ()));
                            player.sendMessage("§fYou have been teleported to " + player2.getName());
                            return true;
                        }
                    }
                } else if(args.length == 2) {
                    player.sendMessage("§fTeleporting a player to another player is not a thing yet");
                } else {
                    player.sendMessage("§cIncorrect usage, the correct usage is §b/tp <player>");
                }
            } else {
                sender.sendMessage("§fThis is only for in-game for now.");
            }
        }
        return true;
    }
}
