package com.teknoserval.elytrablade.handlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerDataHandler {

	private static File playerDataFile;
	private static FileConfiguration playerData;

	private static JavaPlugin main;

	private static List<String> playersGivenBook = new ArrayList<String>();

	public static void init(JavaPlugin main) {

		PlayerDataHandler.main = main;

		playerDataFile = new File(PlayerDataHandler.main.getDataFolder(), "playerData.yml");

		playerData = YamlConfiguration.loadConfiguration(playerDataFile);
		playerData.addDefault("playersGivenBook", new ArrayList<String>());

//		savePlayerData();

		loadPlayerData();

	}

	private static void savePlayerData() {
		try {
			
			playerData.set("playersGivenBook", playersGivenBook);
			
			playerData.save(playerDataFile);
		} catch (IOException e) {
			main.getLogger().log(Level.SEVERE, "Could not save data to " + playerDataFile, e);
		}
	}

	private static void loadPlayerData() {
		try {
			playerData.load(playerDataFile);
		} catch (IOException | InvalidConfigurationException e) {
			main.getLogger().log(Level.SEVERE, "Could not load data from " + playerDataFile, e);
		}

		playersGivenBook = (List<String>) playerData.getList("playersGivenBook");
	}

	public static void addPlayerGivenBook(Player player) {
		
		loadPlayerData();
		
		playersGivenBook.add(player.getUniqueId().toString());
		
		savePlayerData();
	}

	public static boolean hasPlayerBeenGivenBook(Player player) {
		
		loadPlayerData();
		
		System.out.println(playersGivenBook.toString());
		
		return playersGivenBook.contains(player.getUniqueId().toString());
	}

	public static void exit() {
		savePlayerData();
		
	}

}
