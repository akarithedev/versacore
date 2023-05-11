package dev.ayame.versacore.commands;

import dev.ayame.versacore.VersaCore;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

import static org.bukkit.Bukkit.getPlayer;
public class CommandGamemode implements CommandExecutor {

    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof Player) {
                Player player;
                FileConfiguration config = VersaCore.INSTANCE.getConfig();
                if (args.length == 1) {
                    player = (Player) sender;
                    if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "creative"));
                    } else if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "survival"));
                    } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "adventure"));
                    } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("spec")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "spectator"));
                    } else {
                        sender.sendMessage("§cThis is not a valid gamemode");
                    }
                    return false;
                }

                if (args.length > 1) {
                    player = getPlayer(args[0]);
                    if (player == null) {
                        sender.sendMessage("§cThe player is not online");
                        return false;
                    }

                    if (args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("c")) {
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(config.get("others-gamemode-message").toString().replace("{player}", player.getName()).replace("{mode}", "creative"));
                        player.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "creative"));

                    } else if (args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("s")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(config.get("others-gamemode-message").toString().replace("{player}", player.getName()).replace("{mode}", "survival"));
                        player.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "survival"));

                    } else if (args[1].equalsIgnoreCase("adventure") || args[1].equalsIgnoreCase("a")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(config.get("others-gamemode-message").toString().replace("{player}", player.getName()).replace("{mode}", "adventure"));
                        player.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "adventure"));

                    } else if (args[1].equalsIgnoreCase("spectator") || args[1].equalsIgnoreCase("spec")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(config.get("others-gamemode-message").toString().replace("{player}", player.getName()).replace("{mode}", "spectator"));
                        player.sendMessage(config.get("self-gamemode-message").toString().replace("{mode}", "spectator"));

                    }
                    return false;
                }
                sender.sendMessage("§cThis is not a valid gamemode");
                return false;
            }
            sender.sendMessage("§fThis is only for in-game for now.");
        }
        return true;
    }
}
