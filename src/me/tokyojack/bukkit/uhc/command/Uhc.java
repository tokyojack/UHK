package me.tokyojack.mcmarket.uhc.command;

import org.bukkit.command.CommandSender;

import me.tokyojack.mcmarket.uhc.utils.kommand.normalKommand.Kommand;

public class Uhc extends Kommand {

	public Uhc() {
		super("Uhc command");
	}

	@Override
	public boolean execute(CommandSender commandSender, String label, String[] args) {
		commandSender.sendMessage("help menu");
		return false;
	}

}
