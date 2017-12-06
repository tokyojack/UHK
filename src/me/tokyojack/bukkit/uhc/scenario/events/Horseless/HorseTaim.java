package me.tokyojack.mcmarket.uhc.scenario.events.Horseless;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class HorseTaim implements Listener {

	private final List<Material> horseFoods = Arrays.asList(Material.SUGAR, Material.WHEAT, Material.APPLE,
			Material.GOLDEN_CARROT, Material.GOLDEN_APPLE, Material.HAY_BLOCK);

	@EventHandler(ignoreCancelled = true)
	public void horseInteract(PlayerInteractAtEntityEvent event) {
		if (!(event.getRightClicked() instanceof Horse))
			return;

		Player player = event.getPlayer();
		Material handType = player.getItemInHand().getType();

		if (!horseFoods.contains(handType))
			return;

		Material badFood = this.horseFoods.stream().filter(material -> handType == material).findFirst().orElse(null);

		player.sendMessage(Chat.color("You cannot feed a horses " + prettyMaterialString(badFood) + "!"));
	}

	private String prettyMaterialString(Material material) {
		return material.name().toLowerCase().replace("_", " ").substring(0, 1).toUpperCase();
	}

}
