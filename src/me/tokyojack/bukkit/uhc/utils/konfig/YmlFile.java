package me.tokyojack.mcmarket.uhc.utils.konfig;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;
import org.bukkit.plugin.java.JavaPlugin;

import me.tokyojack.mcmarket.uhc.utils.Console;

public class YmlFile extends YamlConfiguration {

	private JavaPlugin plugin;

	private File configFile;
	private String configName;
	private boolean doesLog;

	public YmlFile(JavaPlugin plugin, String configName) {
		this.plugin = plugin;

		this.configFile = new File(plugin.getDataFolder().getAbsolutePath(), configName + ".yml");
		this.configName = configName;

		reload();
	}

	public YmlFile(JavaPlugin plugin, String configName, boolean doesLog) {
		this.plugin = plugin;

		this.configFile = new File(plugin.getDataFolder().getAbsolutePath(), configName + ".yml");
		this.configName = configName;
		this.doesLog = doesLog;

		reload();
	}

	public void reload() {
		if (!configFile.exists()) {
			try {
				configFile.getParentFile().mkdirs();
				configFile.createNewFile();

				if (this.doesLog)
					Console.SUCCESS.log("File '" + this.configName + "' has been created!");

			} catch (IOException exception) {
				Console.INFO.log("Error while creating config " + this.configName);
				exception.printStackTrace();
			}
		}

		try {
			load(configFile);

			if (doesLog)
				Console.SUCCESS.log("File '" + this.configName + "' has been loaded!");

			if (defaults != null) {
				InputStreamReader reader = new InputStreamReader(plugin.getResource(this.configName));
				FileConfiguration defaultsConfig = YamlConfiguration.loadConfiguration(reader);

				setDefaults(defaultsConfig);
				options().copyDefaults(true);

				reader.close();
				save();
			}

		} catch (IOException | InvalidConfigurationException exception) {
			Console.INFO.log("Error while loading config file " + this.configName);
			exception.printStackTrace();
		}
	}

	public void save() {
		try {
			options().indent(2);
			save(configFile);
			if (doesLog)
				Console.SUCCESS.log("File '" + this.configName + "' has been saved!");
		} catch (IOException exception) {
			exception.printStackTrace();
			Console.INFO.log("Error while saving config " + this.configName);
		}
	}

}