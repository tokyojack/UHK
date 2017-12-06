package me.tokyojack.mcmarket.uhc.scenario.events.Horseless;

import org.bukkit.ChatColor;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class HorseMount implements Listener {

	@EventHandler
	public void onHorse(VehicleEnterEvent event) {
		if (!(event.getVehicle() instanceof Horse))
			return;
		
		event.setCancelled(true);
		((Player) event.getEntered()).sendMessage(ChatColor.RED + "You cannot ride horses!");

	}
}
