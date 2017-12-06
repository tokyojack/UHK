package me.tokyojack.mcmarket.uhc.scenario.events.Swordless;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class PlayerAttackEntityWithSword implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void playerAttack(EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player))
			return;

		Player player = (Player) event.getDamager();

		//May not need
		if (player.getItemInHand() == null)
			return;

		if (!player.getItemInHand().getType().name().endsWith("_SWORD"))
			return;

		player.sendMessage(Chat.color("Swords are disabled."));
		event.setCancelled(true);
	}

}
