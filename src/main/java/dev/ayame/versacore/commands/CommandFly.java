package dev.ayame.versacore.commands;

import dev.ayame.versacore.VersaCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CommandFly implements CommandExecutor {

    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, @org.jetbrains.annotations.NotNull Command command, String label, String[] args) {
            if (command.getName().equalsIgnoreCase("fly")) {
                if (sender instanceof Player) {
                    FileConfiguration config = VersaCore.INSTANCE.getConfig();
                    if(args.length > 0) {
                        Player player = getServer().getPlayer(args[0]);
                        if (player == null) {
                            sender.sendMessage("§cThe player is not online");
                        } else {
                            if (!player.getAllowFlight()) {
                                player.setAllowFlight(true);
                                sender.sendMessage(config.get("others-fly-enabled-message").toString().replace("{player}", player.getName()));
                                player.sendMessage(config.get("self-fly-enabled-message").toString());
                            } else {
                                player.setAllowFlight(false);
                                sender.sendMessage(config.get("others-fly-disabled-message").toString().replace("{player}", player.getName()));
                                player.sendMessage(config.get("self-fly-disabled-message").toString());
                            }
                        }
                    } else {
                        Player player = (Player) sender;
                        if (!player.getAllowFlight()) {
                            player.setAllowFlight(true);
                            player.sendMessage(config.get("self-fly-enabled-message").toString());
                        } else {
                            player.setAllowFlight(false);
                            player.sendMessage(config.get("self-fly-disabled-message").toString());
                        }
                    }
                } else {
                    if(args.length > 0) {
                        Player player = getServer().getPlayer(args[0]);
                        FileConfiguration config = VersaCore.INSTANCE.getConfig();
                        if (player == null) {
                            sender.sendMessage("§cThe player is not online");
                        } else {
                            if (!player.getAllowFlight()) {
                                player.setAllowFlight(true);
                                sender.sendMessage(config.get("others-fly-enabled-message").toString().replace("{player}", player.getName()));
                                player.sendMessage(config.get("self-fly-enabled-message").toString());
                            } else {
                                player.setAllowFlight(false);
                                sender.sendMessage(config.get("others-fly-disabled-message").toString().replace("{player}", player.getName()));
                                player.sendMessage(config.get("self-fly-disabled-message").toString());

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
