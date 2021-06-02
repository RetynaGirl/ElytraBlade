package com.teknoserval.elytrablade.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.teknoserval.elytrablade.helpers.InfoBookHelper;

public class InfoCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if (command.getName().equalsIgnoreCase("elytrablade")) {
			System.out.println("Elytrablade command heard");

			if (!(sender instanceof Player)) {

				sender.sendMessage("This command can only be run by a player.");

			} else {
				
				System.out.println("its a player");

				Player player = (Player) sender;

				if (args.length > 0) {
					
					System.out.println("it's got an arg, and its " + args[0]);

					if (args[0].equals("info")) {
						
						System.out.println("its the right arg");
						
						player.getInventory().addItem(InfoBookHelper.generateInfoBook());
						
						return true;
					}
				}

			}

		}
		return false;
	}

}
