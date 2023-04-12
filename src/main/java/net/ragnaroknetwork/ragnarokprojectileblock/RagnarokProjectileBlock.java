package net.ragnaroknetwork.ragnarokprojectileblock;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class RagnarokProjectileBlock extends JavaPlugin implements Listener {

    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("ragnarokprojectileblock").setExecutor(new Command());
        Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
    }

    public void onDisable() {
        System.out.println("[RagnarokProjectileBlock] Disabling plugin.");
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Egg && !getConfig().getBoolean("egg")) event.setCancelled(true);
        if (event.getDamager() instanceof Snowball && !getConfig().getBoolean("snowball")) event.setCancelled(true);
        if (event.getDamager() instanceof FishHook && !getConfig().getBoolean("rod")) event.setCancelled(true);

    }

}

