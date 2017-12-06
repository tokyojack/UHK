package me.tokyojack.mcmarket.uhc.utils.Kountdown.CountdownTimers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.KountdownTimer;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GameCompleteEvent;

public class EndingCountdown extends KountdownTimer {
	
	public EndingCountdown(int timeLeft, JavaPlugin plugin) {
		super(timeLeft, plugin);
	}

	@Override
	public void tick(int timeLeft) {
		Chat.broadcast("Time left until ending: " + timeLeft);		
	}

	@Override
	public void finished() {
		Bukkit.getServer().getPluginManager().callEvent(new GameCompleteEvent());		
	}
}
