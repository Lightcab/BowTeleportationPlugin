package me.lightcab;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class BowTeleportationListener implements Listener {

    BowTeleportationMain plugin;

    public BowTeleportationListener(BowTeleportationMain instance) {
        this.plugin = instance;
    }


    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        Entity entity = event.getEntity();
        ProjectileSource shooter = event.getEntity().getShooter();
        if (shooter instanceof Player && entity instanceof Arrow) {
            Player player = (Player) shooter;
            if (plugin.bowtpPlayers.contains(player.getUniqueId())) {
                player.teleport(entity.getLocation());
            }
        }
    }
}
