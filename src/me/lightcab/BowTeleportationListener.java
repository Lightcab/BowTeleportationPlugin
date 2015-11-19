package me.lightcab;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class BowTeleportationListener implements Listener {

    BowTeleportationMain plugin = BowTeleportationMain.instance;

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        Entity entity = event.getEntity();
        ProjectileSource shooter = entity.getShooter();
        if (shooter instanceof Player && entity instanceof Arrow) {
            Player player = (Player) shooter;
            if (plugin.bowtpPlayers.contains(player.getUUID()) player.teleport(entity.getLocation());
        }
    }
}
