package me.lightcab;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class BowTeleportationMain extends JavaPlugin {
    public List<String> bowtpPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BowTeleportationListener(this), this);
        getLogger().info("The plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("bowtp")) {
            if (sender instanceof Player) {
                if (bowtpPlayers.contains(player.getName())) {
                    bowtpPlayers.remove(player.getName());
                    player.sendMessage(ChatColor.GREEN + "Server> " + ChatColor.WHITE + "Bow Teleportation has been disabled!");
                } else if (!bowtpPlayers.contains(player.getName())) {
                    bowtpPlayers.add(player.getName());
                    player.sendMessage(ChatColor.GREEN + "Server> " + ChatColor.WHITE + "Bow Teleportation has been enabled!");
                }
               return true;
            } else {
               return false;
            }
        }
        return false;
    }
}
