package me.tokyojack.mcmarket.uhc.command.subCommands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.CommandSender;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.kommand.subKommand.SubKommand;

public class SetWorldBordersize extends SubKommand {

	public SetWorldBordersize() {
		super("Set the current world border size", new ArrayList<String>(Arrays.asList("setwb", "swb", "swbz")));

	}

	@Override
	public boolean execute(CommandSender commandSender, String[] args) {
		if (!isNumber(args[0])) {
			commandSender.sendMessage("You must put a number for the amount.");
			return false;
		}

		int amount = Integer.parseInt(args[0]);

		if (amount <= 0) {
			commandSender.sendMessage(Chat.color("The number must be over 0"));
			return false;
		}

		UHC.getPlugin().getWorldBorderManager().getWorldBorder().setSize(amount);

		return true;
	}

	private boolean isNumber(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException exception) {
			return false;
		}
	}

}
