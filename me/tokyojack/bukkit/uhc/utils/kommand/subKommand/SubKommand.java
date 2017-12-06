package me.tokyojack.mcmarket.uhc.utils.kommand.subKommand;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

public abstract class SubKommand {

	private String name = ""; // Not given as the class is the name
	private String decription = "No description set";
	private CommandSenderType commandSenderType = CommandSenderType.CONSOLE;
	private ArrayList<String> alias = new ArrayList<String>();

	public SubKommand() {
	}

	public SubKommand(String description) {
		this.decription = description;
	}

	public SubKommand(CommandSenderType commandSenderType) {
		this.commandSenderType = commandSenderType;
	}

	public SubKommand(String description, CommandSenderType commandSenderType) {
		this.decription = description;
		this.commandSenderType = commandSenderType;
	}

	public SubKommand(ArrayList<String> alias) {
		this.alias = alias;
	}

	public SubKommand(String description, ArrayList<String> alias) {
		this.decription = description;
		this.alias = alias;
	}

	public SubKommand(CommandSenderType commandSenderType, ArrayList<String> alias) {
		this.commandSenderType = commandSenderType;
		this.alias = alias;
	}

	public SubKommand(String description, CommandSenderType commandSenderType, ArrayList<String> alias) {
		this.decription = description;
		this.commandSenderType = commandSenderType;
		this.alias = alias;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.decription;
	}

	public CommandSenderType getCommandSenderType() {
		return this.commandSenderType;
	}

	public ArrayList<String> getAlias() {
		return this.alias;
	}

	public abstract boolean execute(CommandSender commandSender, String[] args);
}