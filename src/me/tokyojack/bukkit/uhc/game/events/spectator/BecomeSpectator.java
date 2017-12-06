package me.tokyojack.mcmarket.uhc.game.events.spectator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.PlayerBecomeSpectatorEvent;

public class BecomeSpectator implements Listener {

	@EventHandler
	public void playerDeath(PlayerBecomeSpectatorEvent event) {
		Player player = event.getPlayer();

		PlayerInventory pi = player.getInventory();
		pi.clear();
		for (ItemStack armorItem : pi.getArmorContents())
			armorItem.setType(Material.AIR);
		player.updateInventory();

		player.setGameMode(GameMode.SPECTATOR);

		UHC.getPlugin().getGamePlayerManager().getAlivePlayers().stream()
				.map(aliveGamePlayer -> Bukkit.getPlayer(aliveGamePlayer.getName()))
				.forEach(alivePlayer -> alivePlayer.hidePlayer(player));
	}
}
