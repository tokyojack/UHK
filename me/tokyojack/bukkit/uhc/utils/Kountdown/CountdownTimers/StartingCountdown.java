package me.tokyojack.mcmarket.uhc.utils.Kountdown.CountdownTimers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.KountdownTimer;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GameStartEvent;

public class StartingCountdown extends KountdownTimer{

	public StartingCountdown(int countdown, JavaPlugin plugin) {
		super(countdown, plugin);

	}

	@Override
	public void tick(int timeLeft) {
		Chat.broadcast("Time left: " + timeLeft);		
	}
	
	@Override
	public void finished() {
		Bukkit.getServer().getPluginManager().callEvent(new GameStartEvent());
		
	}
}
