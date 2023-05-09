package dev.akamethedev.switcher.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CommandFly implements CommandExecutor {
    private FileConfiguration config;

    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, @org.jetbrains.annotations.NotNull Command command, String label, String[] args) {
            if (command.getName().equalsIgnoreCase("fly")) {
                if (sender instanceof Player) {
                    if(args.length > 0) {
                        Player player = getServer().getPlayer(args[0]);
                        if (player == null) {
                            sender.sendMessage("§cThe player is not online");
                        } else {
                            if (!player.getAllowFlight()) {
                                player.setAllowFlight(true);
                                sender.sendMessage("§fYou have enabled flying mode for " + player.getName());
                            } else {
                                player.setAllowFlight(false);
                                sender.sendMessage("§fYou have disabled flying mode for " + player.getName());
                            }
                        }
                    } else {
                        Player player = (Player) sender;
                        if (!player.getAllowFlight()) {
                            player.setAllowFlight(true);
                            player.sendMessage(config.getString("self-fly-enabled-message"));
                        } else {
                            player.setAllowFlight(false);
                            player.sendMessage(config.getString("self-fly-disabled-message"));
                        }
                    }
                } else {
                    if(args.length > 0) {
                        Player player = getServer().getPlayer(args[0]);
                        if (player == null) {
                            sender.sendMessage("§cThe player is not online");
                        } else {
                            if (!player.getAllowFlight()) {
                                player.setAllowFlight(true);
                                sender.sendMessage("§fYou have enabled flying mode for " + player.getName());
                            } else {
                                player.setAllowFlight(false);
                                sender.sendMessage("§fYou have disabled flying mode for " + player.getName());
                            }
                        }
                    } else {
                        sender.sendMessage("§cIncorrect usage, the correct usage is §b/fly <player>");
                    }
                }
            }
        return true;
    }

}