package me.tokyojack.mcmarket.uhc.command.subCommands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.kommand.subKommand.SubKommand;

public class StartGame extends SubKommand {

	public StartGame() {
		super("Starts the game without the required amount of players", new ArrayList<String>(Arrays.asList("start")));
	}

	@Override
	public boolean execute(CommandSender commandSender, String[] args) {
		if (Bukkit.getOnlinePlayers().size() < 2) {
			commandSender.sendMessage("Must be atleast 2 players on to start a game");
			return false;
		}

		commandSender.sendMessage("Game started");
		UHC.getPlugin().getGameManager().startGame();

		return true;
	}

}
