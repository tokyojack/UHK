package me.tokyojack.mcmarket.uhc.utils.Kountdown;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.tokyojack.mcmarket.uhc.utils.Console;

public abstract class KountdownPlayer {

	private Map<String, Integer> playerNames = new HashMap<String, Integer>();

	private int seconds;
	private JavaPlugin plugin;

	private boolean isStarted;
	private int runnableID;

	public KountdownPlayer(JavaPlugin plugin) {
		this.seconds = 1;
		this.plugin = plugin;

		this.isStarted = false;
		this.runnableID = 0;
	}

	public KountdownPlayer(int seconds, JavaPlugin plugin) {
		this.seconds = seconds;
		this.plugin = plugin;

		this.isStarted = false;
		this.runnableID = 0;
	}

	public abstract void tick(Player player, int countdown);

	public abstract void finished(Player player);

	public void addPlayer(Player player, int time) {
		if (!this.isStarted) //If it isn't started
			start();
		
		this.playerNames.put(player.getName(), time);
	}

	public void removePlayer(Player player) {
		this.playerNames.remove(player.getName());

		if (this.playerNames.size() <= 0)
			stop();
	}

	public Boolean containsPlayer(Player player) {
		return this.playerNames.containsKey(player.getName());
	}

	public void start() {
		Console.ERROR.log("KountdownPlayer start called.");
		this.isStarted = true;
		this.runnableID = this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
			public void run() {
				List<Player> players = playerNames.keySet().stream().map(playerName -> Bukkit.getPlayer(playerName))
						.collect(Collectors.toList());

				players.forEach(player -> {
					if (player != null) {
						int amount = playerNames.get(player.getName());
						if ((amount - 1) <= 0) {
							playerNames.remove(player.getName());
							finished(player);
							return;
						}
						tick(player, amount);
						playerNames.put(player.getName(), amount - 1);
					}
				});

			}
		}, 0, this.seconds * 20);
	}

	private void stop() {
		Console.ERROR.log("KountdownPlayer stop called.");
		this.isStarted = false;
		Bukkit.getScheduler().cancelTask(this.runnableID);
	}

}
