package dev.akamethedev.switcher.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.akamethedev.switcher.handlers.dataHandler;
public class CommandSwitcher implements CommandExecutor {
    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, @org.jetbrains.annotations.NotNull Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("switcher")) {
            if(args.length > 0) {
                if(args[0].equals("reload")) {
                    if(sender instanceof Player) {
                        Player player = (Player) sender;
                        if(player.hasPermission("akm.reload")) {
                            player.sendMessage("§cI am sorry but you cannot use this command");
                        } else {
                            dataHandler.INSTANCE.updateConfig();
                            dataHandler.INSTANCE.updateData();
                            player.sendMessage("[switcher] §fPlugin successfully reloaded");
                        }
                    } else {
                        dataHandler.INSTANCE.updateConfig();
                        dataHandler.INSTANCE.updateData();
                        sender.sendMessage("[switcher] §fPlugin successfully reloaded");
                    }
                }
            } else {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.sendMessage("§fAvailable commands:\n§b/switcher - §fShows this message\n§b/gamemode - §fSets your gamemode or someones gamemode to a mode of your choice\n§b/fly - §fToggles fly mode for yourself or a person you want\n§b/heal - §fHeals yourself or a person you want\n§b/tp - §fTeleport to a player\n§b/switcher reload - §fReloads the config\n§b/setspawn - §fSets the spawn to current location\n§b/spawn - §fTeleport to spawn");
                } else {
                    sender.sendMessage("§fAvailable commands:\n§b/switcher - §fShows this message\n§b/gamemode - §fSets your gamemode or someones gamemode to a mode of your choice\n§b/fly - §fToggles fly mode for yourself or a person you want\n§b/heal - §fHeals yourself or a person you want\n§b/tp - §fTeleport to a player\n§b/switcher reload - §fReloads the config\n§b/setspawn - §fSets the spawn to current location\n§b/spawn - §fTeleport to spawn");

                }
            }
        }
        return true;
    }
}
