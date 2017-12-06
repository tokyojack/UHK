package me.tokyojack.mcmarket.uhc.scenario.events.NoClean;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.KountdownPlayer;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerDamagePlayerEvent;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerKilledPlayerEvent;

public class ProtectionGainWhenKilledPlayer implements Listener {

	private KountdownPlayer protectedPlayers = new KountdownPlayer(UHC.getPlugin()) {
		@Override
		public void tick(Player player, int countdown) {
			player.sendMessage("Countdown is " + countdown);
		}

		@Override
		public void finished(Player player) {
			player.sendMessage("Protection ran out");
		}
	};

	@EventHandler
	public void playerKill(PlayerKilledPlayerEvent event) {
		Player killer = event.getKiller();

		this.protectedPlayers.addPlayer(killer, 20);
		killer.sendMessage(Chat.color("You've gained a 20 second kill protection for killing a player."));
	}

	@EventHandler
	public void protectedPlayerDamageOtherPlayer(PlayerDamagePlayerEvent event) {
		Player damager = event.getDamager();

		if (!this.protectedPlayers.containsPlayer(damager))
			return;

		this.protectedPlayers.removePlayer(damager);
		damager.sendMessage(Chat.color("Your kill protection has been removed as you've hit another player."));
	}

	@EventHandler
	public void playerDamageOtherProtectedPlayer(PlayerDamagePlayerEvent event) {
		if (!this.protectedPlayers.containsPlayer(event.getVictim()))
			return;

		event.getDamager().sendMessage(Chat.color("That player has kill protection"));
		event.setCancelled(true);
	}
}
