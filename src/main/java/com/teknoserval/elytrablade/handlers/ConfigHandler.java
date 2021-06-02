package com.teknoserval.elytrablade.handlers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHandler {
	
	private static FileConfiguration config;

	public static void init(JavaPlugin main) {
		
		config = main.getConfig();

		config.addDefault("strike.enable", true);
		config.addDefault("strike.damageFactor", 10);
		config.addDefault("strike.damageRadius", 1);
		config.addDefault("strike.timeout.enable", false);
		config.addDefault("strike.timeout.millis", 3000);

		config.options().copyDefaults(true);
		
		main.saveConfig();

	}
	
	public static int getDamageFactor() {
		return config.getInt("strike.damageFactor");
	}
	
	public static boolean getStrikeEnabled() {
		return config.getBoolean("strike.enable");
	}
	
	public static int getStrikeTimeout() {
		return config.getInt("strike.timeout.millis");
	}
	
	public static int getDamageRadius() {
		return config.getInt("strike.damageRadius");
	}
	
	public static boolean getStrikeTimeoutEnabled() {
		return config.getBoolean("strike.timeout.enabled");
	}

}
