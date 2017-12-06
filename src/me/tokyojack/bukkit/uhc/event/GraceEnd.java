package me.tokyojack.mcmarket.uhc.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.game.objects.GameState;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GraceEndEvent;

public class GraceEnd implements Listener {

	@EventHandler
	public void graceEnd(GraceEndEvent event) {
		Chat.broadcast("Grace has ended boi's");
		UHC.getPlugin().getGameManager().getGame().setGameState(GameState.FIGHTNING);
		UHC.getPlugin().getWorldBorderManager().start();
	}

}
