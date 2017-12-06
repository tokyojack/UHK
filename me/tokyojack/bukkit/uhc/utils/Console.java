package me.tokyojack.mcmarket.uhc.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public enum Console {
	ERROR(ChatColor.RED + "[ERROR]"),
	SUCCESS(ChatColor.GREEN + "[SUCCESS]"),
	INFO(ChatColor.WHITE + "[INFO]");

	final String LOG_PREFIX = ChatColor.GOLD + "[UHC]";
	private String prefix;

	private Console(String prefix) {
		this.prefix = prefix;
	}

	public void log(String message) {
		logToConsole(LOG_PREFIX + " " + this.prefix + ": " + ChatColor.translateAlternateColorCodes('&', message));
	}

	public void log(int number) {
		logToConsole(LOG_PREFIX + " " + this.prefix + ": " + number);
	}

	public void log(float number) {
		logToConsole(LOG_PREFIX + " " + this.prefix + ": " + number);
	}

	public void log(double number) {
		logToConsole(LOG_PREFIX + " " + this.prefix + ": " + number);
	}

	public void log(boolean bool) {
		logToConsole(LOG_PREFIX + " " + this.prefix + ": " + bool);
	}

	public void log(List<String> list) {
		list.forEach(item -> logToConsole(LOG_PREFIX + " " + this.prefix + ": " + item));
	}

	private void logToConsole(String message) {
		Bukkit.getServer().getConsoleSender().sendMessage(message);
	}
}