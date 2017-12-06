package me.tokyojack.mcmarket.uhc.game.events.lobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.game.objects.BlockedDamage;

public class NoPlayerDamageTakenWhileWaiting implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void playerDamaged(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;

		if (UHC.getPlugin().getGameManager().getGame().isIngame())
			return;

		if (UHC.getPlugin().getGameManager().getGame().getDamageTakenType() != BlockedDamage.ALL)
			return;

		event.setCancelled(true);
	}
}
