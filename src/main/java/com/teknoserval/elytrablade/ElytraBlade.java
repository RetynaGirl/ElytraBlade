package com.teknoserval.elytrablade;

import org.bukkit.plugin.java.JavaPlugin;

import com.teknoserval.elytrablade.commands.InfoCommandExecutor;
import com.teknoserval.elytrablade.handlers.ConfigHandler;
import com.teknoserval.elytrablade.handlers.PlayerDataHandler;
import com.teknoserval.elytrablade.listeners.EventListener;

/**
 * Hello world!
 *
 */
public class ElytraBlade extends JavaPlugin {

	@Override
	public void onEnable() {

		this.getCommand("elytrablade").setExecutor(new InfoCommandExecutor());

		getLogger().info("Time to Swoop!");

		ConfigHandler.init(this);

		PlayerDataHandler.init(this);

		getServer().getPluginManager().registerEvents(new EventListener(this), this);

	}

	@Override
	public void onDisable() {
		getLogger().info("Away, Away with Ye!");
		
		PlayerDataHandler.exit();
	}

}
