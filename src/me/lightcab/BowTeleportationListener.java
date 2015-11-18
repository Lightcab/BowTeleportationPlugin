package me.lightcab;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class BowTeleportationListener implements Listener {

    BowTeleportationMain plugin;

    public BowTeleportationListener(BowTeleportationMain instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {
        Player p = (Player) e.getEntity().getShooter();
        Entity entity = e.getEntity();
        if (plugin.bowtpPlayers.contains(p.getName())) {
            if (entity instanceof Arrow) {
                p.teleport(entity.getLocation());
            }
        }
    }
}
