package me.tokyojack.mcmarket.uhc.group.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.group.GroupManager;
import me.tokyojack.mcmarket.uhc.utils.Chat;

public class PlayerChatInGroup implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void playerChat(AsyncPlayerChatEvent event) {
		if (!Character.toString(event.getMessage().charAt(0)).equals("@"))
			return;

		Player player = event.getPlayer();
		GroupManager manager = UHC.getPlugin().getGroupManager();

		// Dead/Spectator
		if (UHC.getPlugin().getGamePlayerManager().isDead(player.getName()))
			return;

		String message = Chat.color("&e[TEAM] " + player.getName() + ": &f" + event.getMessage().substring(1));

		manager.getGroupByPlayerName(player.getName()).getMembers().stream()
				.map(groupMember -> Bukkit.getPlayer(groupMember))
				.forEach(groupMemberPlayer -> groupMemberPlayer.sendMessage(message));

		event.setCancelled(true);
	}

}
