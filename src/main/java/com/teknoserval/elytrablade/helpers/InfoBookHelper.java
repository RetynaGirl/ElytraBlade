package com.teknoserval.elytrablade.helpers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class InfoBookHelper {
	
	public static ItemStack generateInfoBook() {
		System.out.println("Info Book Requested");
		
		ItemStack infoBook = new ItemStack(Material.WRITTEN_BOOK, 1);
		
		ItemMeta itemMeta = infoBook.getItemMeta();
		
		if (itemMeta instanceof BookMeta) {
			BookMeta meta = (BookMeta) itemMeta;
			
			meta.setAuthor("TeknoServal");
			meta.setTitle("ElytraBlade Information");
			
			List<String> pages = new ArrayList<String>();
			
			pages.add("Welcome to the ElytraBlade Primer! This book will teach you everything you need to know about your new and improved Elytra!");
			pages.add("First, and most importantly, you can now DEAL DAMAGE with your elytra! Yes, you can now swoop down on your enemies and absolutely MURDERIZE them!");
			pages.add("Now, you may be wondering, \"How much damage does it do?\" Well, it scales with your speed, going from barely more than a punch to even oneshotting some types of monsters.");
			pages.add("A warning, though: be careful, as you need to be quite accurate with your flight in order to not crash while attempting an epic dive-bomb on your neighborhood creeper.");
			pages.add("Lastly, your farms and villager \"dwellings\" are safe, as you may avoid damaging kind, helpful creatures by crouching in flight. Now, go have some fun, since It's Time to Swoop!");
			pages.add("You may request this book again by using the command /elytrablade info");
			
			
			meta.setPages(pages);
			
			infoBook.setItemMeta(meta);
		}
		
		return infoBook;
	}

}
