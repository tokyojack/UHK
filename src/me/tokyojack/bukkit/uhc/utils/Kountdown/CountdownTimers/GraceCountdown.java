package me.tokyojack.mcmarket.uhc.utils.Kountdown.CountdownTimers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.KountdownTimer;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GraceEndEvent;

public class GraceCountdown extends KountdownTimer {

	public GraceCountdown(int timeLeft, JavaPlugin plugin) {
		super(timeLeft, plugin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(int timeLeft) {
		Chat.broadcast("Time left for grace: " + timeLeft);
	}

	@Override
	public void finished() {
		Bukkit.getServer().getPluginManager().callEvent(new GraceEndEvent());
	}
}
