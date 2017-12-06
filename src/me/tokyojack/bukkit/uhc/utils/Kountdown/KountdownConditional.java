package me.tokyojack.mcmarket.uhc.utils.Kountdown;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class KountdownConditional {

	// Change to different timeLeft?
	private int repeatedTimeInSeconds;
	private int runnableID;

	private JavaPlugin plugin;

	public KountdownConditional(JavaPlugin plugin) {
		this.repeatedTimeInSeconds = 1;
		this.runnableID = 0;

		this.plugin = plugin;
	}

	public KountdownConditional(int repeatedTimeInSeconds, JavaPlugin plugin) {
		this.repeatedTimeInSeconds = repeatedTimeInSeconds;
		this.runnableID = 0;

		this.plugin = plugin;
	}

	public abstract void tick(int timeLeft);

	public abstract boolean checkToStop();

	public abstract void finished();

	public void start() {
		runnableID = this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
			public void run() {

				if (checkToStop()) {
					finished();
					stop();
					return;
				}

				tick(repeatedTimeInSeconds);
			}
		}, 0, this.repeatedTimeInSeconds * 20);

	}

	public void stop() {
		Bukkit.getScheduler().cancelTask(this.runnableID);
	}
}
