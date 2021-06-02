package com.teknoserval.elytrablade.listeners;

import java.time.Instant;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.teknoserval.elytrablade.handlers.ConfigHandler;
import com.teknoserval.elytrablade.handlers.PlayerDataHandler;
import com.teknoserval.elytrablade.helpers.PlayerStrikeTimeHelper;
import com.teknoserval.elytrablade.runnables.GiveInfoBookRunnable;

public class EventListener implements Listener {
	
	private JavaPlugin plugin;
	
	public EventListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}


	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		
		System.out.println("Player logon event");
		
		Player player = event.getPlayer();
		
		if (ConfigHandler.getStrikeTimeoutEnabled()) {
			
			PlayerStrikeTimeHelper.setPlayerStrikeTime(event.getPlayer().getUniqueId(), Instant.now().plusMillis(ConfigHandler.getStrikeTimeout()));
		} else {
			PlayerStrikeTimeHelper.setPlayerStrikeTime(event.getPlayer().getUniqueId(), Instant.now());

		}
		
		if (!PlayerDataHandler.hasPlayerBeenGivenBook(player)) {
			
			System.out.println("Player has not been given book");
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new GiveInfoBookRunnable(player), 60L);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		
		
		Player player = event.getPlayer();

		if (player.isGliding() && PlayerStrikeTimeHelper.getPlayerStrikeTime(player.getUniqueId())
				.isBefore(Instant.now()) && !player.isSneaking()) {
			
			int damageRadius = ConfigHandler.getDamageRadius();
			List<Entity> nearbyEntities = player.getNearbyEntities(damageRadius, damageRadius, damageRadius);

			if (!nearbyEntities.isEmpty()) {
				for (Entity nearbyEntity : nearbyEntities) {
					if (nearbyEntity instanceof LivingEntity) {
						System.out.println(nearbyEntity.toString() + " " + player.isGliding() + " "
								+ player.getVelocity().length());
						((LivingEntity) nearbyEntity).damage(player.getVelocity().length() * ConfigHandler.getDamageFactor(), player);
					}
				}

				if (ConfigHandler.getStrikeTimeoutEnabled()) {
					
					PlayerStrikeTimeHelper.setPlayerStrikeTime(event.getPlayer().getUniqueId(), Instant.now().plusMillis(ConfigHandler.getStrikeTimeout()));
				} else {
					PlayerStrikeTimeHelper.setPlayerStrikeTime(event.getPlayer().getUniqueId(), Instant.now());

				}
			}

		}

	}
	


}
