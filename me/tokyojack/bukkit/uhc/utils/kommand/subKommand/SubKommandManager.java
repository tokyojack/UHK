package me.tokyojack.mcmarket.uhc.utils.kommand.subKommand;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import me.tokyojack.mcmarket.uhc.utils.kommand.normalKommand.Kommand;

public class SubKommandManager extends BukkitCommand {

	private Kommand command;
	private boolean doesProvideHelpMessage;

	private List<SubKommand> subCommands = new ArrayList<SubKommand>();

	public SubKommandManager(Kommand command) {
		// For the check of sub-args
		super(command.getClass().getSimpleName().toLowerCase(), command.getDescription(),
				"/" + command.getClass().getSimpleName().toLowerCase(), command.getAliases());

		// For the normal no-arg cmd
		command.setName(command.getClass().getSimpleName().toLowerCase());
		command.setUsage("/" + command.getClass().getSimpleName().toLowerCase());
		this.command = command;
		this.doesProvideHelpMessage = false;
	}

	public SubKommandManager(Kommand command, boolean doesProvideHelpMessage) {
		// For the check of sub-args
		super(command.getClass().getSimpleName().toLowerCase(), command.getDescription(),
				"/" + command.getClass().getSimpleName().toLowerCase(), command.getAliases());

		// For the normal no-arg cmd
		command.setName(command.getClass().getSimpleName().toLowerCase());
		command.setUsage("/" + command.getClass().getSimpleName().toLowerCase());
		this.command = command;
		this.doesProvideHelpMessage = doesProvideHelpMessage;
	}

	public SubKommandManager addSubCommand(SubKommand kommand) {
		kommand.setName(kommand.getClass().getSimpleName().toLowerCase());
		this.subCommands.add(kommand);
		return this;
	}

	public void build() {
		try {
			Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

			bukkitCommandMap.setAccessible(true);
			CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

			commandMap.register(command.getName(), this);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (!(this.command.getAliases().contains(label.toLowerCase())
				|| this.command.getName().equalsIgnoreCase(label)))
			return false;

		if (args.length <= 0) {
			if (this.doesProvideHelpMessage) {
				sender.sendMessage(ChatColor.GREEN + "=====" + this.command.getName() + "=====");
				this.subCommands.forEach(subCommand -> sender.sendMessage(ChatColor.YELLOW + "/"
						+ subCommand.getClass().getSimpleName().toLowerCase() + " | " + subCommand.getDescription()));
			} else
				this.command.execute(sender, label, args);
			return false;
		}

		String subCommand = args[0];

		boolean isFound = false;
		SubKommand subCommandItem = null;

		for (SubKommand subCommandEntry : this.subCommands) {
			if (subCommandEntry.getName().equalsIgnoreCase(subCommand)
					|| subCommandEntry.getAlias().contains(subCommand.toLowerCase())) {
				isFound = true;
				subCommandItem = subCommandEntry;
				break;
			}
		}

		if (!isFound) {
			sender.sendMessage(ChatColor.RED + "Unknown sub command '" + subCommand + "'");
			return false;
		}

		if (subCommandItem.getCommandSenderType() == CommandSenderType.PLAYER) {
			if (sender instanceof Player) {
				subCommandItem.execute(sender, args);
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Only players can '" + this.command.getName() + "'");
				return false;
			}
		} else {

			String[] removeFirstArg = new ArrayList<String>(Arrays.asList(args)).stream()
					.filter(item -> item.equalsIgnoreCase(subCommand)).toArray((String[]::new));

			subCommandItem.execute(sender, removeFirstArg);
			return true;
		}
	}
}
