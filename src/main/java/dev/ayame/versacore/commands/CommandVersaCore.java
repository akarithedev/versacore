package dev.ayame.versacore.commands;

import dev.ayame.versacore.handlers.dataHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.ayame.versacore.VersaCore;

public class CommandVersaCore implements CommandExecutor {
    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, @org.jetbrains.annotations.NotNull Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("versacore")) {
            if(args.length > 0) {
                if(args[0].equals("reload")) {
                    if(sender instanceof Player) {
                        Player player = (Player) sender;
                        if(!player.hasPermission("versacore.reload")) {
                            player.sendMessage("§cI am sorry but you cannot use this command");
                        } else {
                            dataHandler.INSTANCE.updateConfig();
                            dataHandler.INSTANCE.updateData();
                            player.sendMessage("[versacore] §fPlugin successfully reloaded");
                        }
                    } else {
                        dataHandler.INSTANCE.updateConfig();
                        dataHandler.INSTANCE.updateData();
                        sender.sendMessage("[versacore] §fPlugin successfully reloaded");
                    }
                } else if(args[0].equals("version")) {
                    if(sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage("§fYou are running version " + VersaCore.INSTANCE.getDescription().getVersion() + " of versacore");
                    } else {
                        sender.sendMessage("§fYou are running version " + VersaCore.INSTANCE.getDescription().getVersion() + " of versacore");
                    }
                }
            } else {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.sendMessage("§fAvailable commands:\n§b/versacore - §fShows this message\n§b/gamemode - §fSets your gamemode or someones gamemode to a mode of your choice\n§b/fly - §fToggles fly mode for yourself or a person you want\n§b/heal - §fHeals yourself or a person you want\n§b/tp - §fTeleport to a player\n§b/setspawn - §fSets the spawn to current location\n§b/spawn - §fTeleport to spawn\n§b/versacore reload - §fReloads the plugin\n§b/versacore version - §fGet the version of the plugin");
                } else {
                    sender.sendMessage("§fAvailable commands:\n§b/versacore - §fShows this message\n§b/gamemode - §fSets your gamemode or someones gamemode to a mode of your choice\n§b/fly - §fToggles fly mode for yourself or a person you want\n§b/heal - §fHeals yourself or a person you want\n§b/tp - §fTeleport to a player\n§b/setspawn - §fSets the spawn to current location\n§b/spawn - §fTeleport to spawn\n§b/versacore reload - §fReloads the plugin\n§b/versacore version - §fGet the version of the plugin");

                }
            }
        }
        return true;
    }
}
