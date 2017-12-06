package me.tokyojack.mcmarket.uhc.utils.kommand.normalKommand;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

public class KommandManager {

	private Map<String, Kommand> commands = new HashMap<String, Kommand>();

	public KommandManager() {

	}

	public KommandManager addCommand(Kommand kommand) {
		if (kommand.getName() == null) {
			kommand.setName(kommand.getClass().getSimpleName().toLowerCase());
			kommand.setUsage("/" + kommand.getClass().getSimpleName().toLowerCase());
		}
		this.commands.put(kommand.getClass().getSimpleName().toLowerCase(), kommand);
		return this;
	}

	public void build() {
		this.commands.values().forEach(command -> {
			try {
				Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

				bukkitCommandMap.setAccessible(true);
				CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

				commandMap.register(command.getName(), command);

			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO Handle exceptions
				e.printStackTrace();
			}
		});
	}

}
