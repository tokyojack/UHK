package me.tokyojack.mcmarket.uhc.world.qualityOfGameplay;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class ArmourBreak implements Listener {

	@EventHandler
	public void ArmorBreak(PlayerItemBreakEvent e) {
		Player player = e.getPlayer();
		Material item = e.getBrokenItem().getType();

		String[] itemType = item.name().split("_");

		if (itemType.length <= 0)
			return;

		switch (itemType[1]) { //Right side, ex: DIAMOND_HELMET
		case "HELMET":
			player.sendMessage(Chat.color("Your helmet has broke"));
			break;
		case "CHESTPLATE":
			player.sendMessage(Chat.color("Your chestplate has broke"));
			break;
		case "LEGGINGS":
			player.sendMessage(Chat.color("Your leggings has broke"));
			break;
		case "BOOTS":
			player.sendMessage(Chat.color("Your boots has broke"));
			break;
		}

	}
}
