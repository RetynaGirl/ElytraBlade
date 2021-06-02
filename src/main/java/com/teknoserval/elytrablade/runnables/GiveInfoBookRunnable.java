package com.teknoserval.elytrablade.runnables;

import org.bukkit.entity.Player;

import com.teknoserval.elytrablade.handlers.PlayerDataHandler;
import com.teknoserval.elytrablade.helpers.InfoBookHelper;

public class GiveInfoBookRunnable implements Runnable {
	
	private Player player;

	public GiveInfoBookRunnable(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		player.getInventory().addItem(InfoBookHelper.generateInfoBook());
		
		PlayerDataHandler.addPlayerGivenBook(player);
		
	}

}
