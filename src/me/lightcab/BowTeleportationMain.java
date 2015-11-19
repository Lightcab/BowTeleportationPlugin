package me.lightcab;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BowTeleportationMain extends JavaPlugin {

    protected Set<UUID> bowtpPlayers = new HashSet<>();

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
        if (cmd.getName().equalsIgnoreCase("bowtp")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (bowtpPlayers.contains(player.getUniqueId())) {
                    bowtpPlayers.remove(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Server> " + ChatColor.WHITE + "Bow Teleportation has been disabled!");
                } else if (!bowtpPlayers.contains(player.getUniqueId())) {
                    bowtpPlayers.add(player.getUniqueId());
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
