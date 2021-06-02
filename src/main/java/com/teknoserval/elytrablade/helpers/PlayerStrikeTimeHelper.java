package com.teknoserval.elytrablade.helpers;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerStrikeTimeHelper {
	
	private static Map<UUID, Instant> playerStrikeTime = new HashMap<>();
	
	 public static Instant getPlayerStrikeTime(UUID uuid) {
	        return playerStrikeTime.get(uuid);
	    }

	    public static void setPlayerStrikeTime(UUID uuid, Instant instant) {
	        playerStrikeTime.put(uuid, instant);
	    }

}
