package me.tokyojack.mcmarket.uhc.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Chat {

	public static String color(String text){
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static String clear(String text){
		return ChatColor.stripColor(text);
	}
	
	public static void broadcast(String text){
		Bukkit.broadcastMessage(Chat.color(text));
	}
}
