package dev.ayame.versacore.commands;

import static org.bukkit.Bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {
    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, @org.jetbrains.annotations.NotNull Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length == 0) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    sender.sendMessage("§fYou have healed yourself");
                } else if(args.length == 1) {
                    Player player2 = (Player) getPlayer(args[0]);
                    if(player2 == null) {
                        sender.sendMessage("§cThe player is not online");
                    } else {
                        player2.setHealth(20);
                        player2.setFoodLevel(20);
                        player2.sendMessage("§fYou have been healed by " + player.getName());
                        player.sendMessage("§fYou have healed " + player2.getName());
                    }

                } else {
                    player.sendMessage("§cIncorrect usage, the correct usage is §b/heal <player>");
                }

            } else {
                if(args.length > 0) {
                    Player player1 = (Player) getPlayer(args[0]);
                    if(player1 == null) {
                        sender.sendMessage("§cThe player is not online");
                    } else {
                        player1.setHealth(20);
                        player1.setFoodLevel(20);
                        player1.sendMessage("§fYou have been healed by " + sender.getName());
                        sender.sendMessage("§fYou have healed " + player1.getName());
                    }
                } else {
                    sender.sendMessage("§cIncorrect usage, the correct usage is §b/heal <player>");
                    return false;
                }
            }
        }

        return true;
    }
}
