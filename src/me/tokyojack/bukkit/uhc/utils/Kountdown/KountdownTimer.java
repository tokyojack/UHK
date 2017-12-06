package me.tokyojack.mcmarket.uhc.utils.Kountdown;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class KountdownTimer {

	// Change to different timeLeft?
	private int timeLeft;
	private int seconds;
	private int runnableID;

	private final int ORGINAL_TIME;
	private JavaPlugin plugin;

	public KountdownTimer(int timeLeft, JavaPlugin plugin) {
		this.timeLeft = timeLeft;
		this.seconds = 1;
		this.runnableID = 0;

		this.ORGINAL_TIME = timeLeft;
		this.plugin = plugin;
	}

	public KountdownTimer(int timeLeft, int seconds, JavaPlugin plugin) {
		this.timeLeft = timeLeft;
		this.seconds = seconds;
		this.runnableID = 0;

		this.ORGINAL_TIME = timeLeft;
		this.plugin = plugin;
	}

	public abstract void tick(int timeLeft);

	public abstract void finished();

	public void start() {
		runnableID = this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
			public void run() {

				if (timeLeft <= 0) {
					finished();
					Bukkit.getScheduler().cancelTask(runnableID);
					return;
				}

				tick(timeLeft);
				timeLeft--;
			}
		}, 0, this.seconds * 20);

	}

	public void stop() {
		resetTimeLeft();
		Bukkit.getScheduler().cancelTask(this.runnableID);
	}

	public void resetTimeLeft() {
		this.timeLeft = this.ORGINAL_TIME;
	}

}
