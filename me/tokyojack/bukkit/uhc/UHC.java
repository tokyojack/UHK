package me.tokyojack.mcmarket.uhc;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.tokyojack.mcmarket.uhc.command.Uhc;
import me.tokyojack.mcmarket.uhc.command.subCommands.SetWorldBordersize;
import me.tokyojack.mcmarket.uhc.command.subCommands.StartGame;
import me.tokyojack.mcmarket.uhc.event.GameComplete;
import me.tokyojack.mcmarket.uhc.event.GameStart;
import me.tokyojack.mcmarket.uhc.event.GameWin;
import me.tokyojack.mcmarket.uhc.event.GraceEnd;
import me.tokyojack.mcmarket.uhc.game.GameManager;
import me.tokyojack.mcmarket.uhc.game.events.PlayerChat;
import me.tokyojack.mcmarket.uhc.game.events.PlayerDeathWin;
import me.tokyojack.mcmarket.uhc.game.events.PlayerJoinGame;
import me.tokyojack.mcmarket.uhc.game.events.PlayerLeaveGame;
import me.tokyojack.mcmarket.uhc.game.events.StopPlayerDamagingPlayer;
import me.tokyojack.mcmarket.uhc.game.events.StopPlayerDamagingPlayerWithBow;
import me.tokyojack.mcmarket.uhc.game.events.spectator.BecomeSpectator;
import me.tokyojack.mcmarket.uhc.game.events.spectator.SpectatorChat;
import me.tokyojack.mcmarket.uhc.gamePlayer.GamePlayerManager;
import me.tokyojack.mcmarket.uhc.gamePlayer.events.ProfileCreateOnJoin;
import me.tokyojack.mcmarket.uhc.gamePlayer.events.ProfilePlayerDeath;
import me.tokyojack.mcmarket.uhc.gamePlayer.events.ProfileRemoveOnLeave;
import me.tokyojack.mcmarket.uhc.gamePlayer.events.score.GappleEat;
import me.tokyojack.mcmarket.uhc.gamePlayer.events.score.PlayerKillPointIncrease;
import me.tokyojack.mcmarket.uhc.group.GroupManager;
import me.tokyojack.mcmarket.uhc.group.events.PlayerChatInGroup;
import me.tokyojack.mcmarket.uhc.group.events.PlayerDamageOtherMember;
import me.tokyojack.mcmarket.uhc.group.events.PlayerShootOtherMember;
import me.tokyojack.mcmarket.uhc.group.events.RemoveFromGroupOnLeave;
import me.tokyojack.mcmarket.uhc.scenario.ScenarioManager;
import me.tokyojack.mcmarket.uhc.utils.Console;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.EnderpearlThrowEvent;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerDamagePlayerEvent;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerKilledPlayerEvent;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerShootPlayerEvent;
import me.tokyojack.mcmarket.uhc.utils.kommand.subKommand.SubKommandManager;
import me.tokyojack.mcmarket.uhc.world.events.CustomWhitelistMessage;
import me.tokyojack.mcmarket.uhc.world.events.NoWeather;
import me.tokyojack.mcmarket.uhc.world.events.NoWitherSpawn;
import me.tokyojack.mcmarket.uhc.world.events.PlayerJoinMessage;
import me.tokyojack.mcmarket.uhc.world.events.PlayerLeaveMessage;
import me.tokyojack.mcmarket.uhc.world.qualityOfGameplay.ArmourBreak;
import me.tokyojack.mcmarket.uhc.world.qualityOfGameplay.BowSound;
import me.tokyojack.mcmarket.uhc.world.qualityOfGameplay.PotionRemove;
import me.tokyojack.mcmarket.uhc.worldborder.WorldBorderManager;

@Getter
public class UHC extends JavaPlugin {

	@Getter
	private static UHC plugin;

	private GroupManager groupManager;
	private GameManager gameManager;
	private GamePlayerManager gamePlayerManager;
	private ScenarioManager scenarioManager;
	private WorldBorderManager worldBorderManager;

	public void onEnable() {
		getLogger().info(">>Plugin " + getDescription().getName() + " is enabled! By tokyojack <3.!");
		plugin = this;

		groupManager = new GroupManager();
		gameManager = new GameManager();
		gamePlayerManager = new GamePlayerManager();
		scenarioManager = new ScenarioManager();
		worldBorderManager = new WorldBorderManager();

		new PlayerKilledPlayerEvent().registerListener(this);
		new EnderpearlThrowEvent().registerListener(this);
		new PlayerDamagePlayerEvent().registerListener(this);
		new PlayerShootPlayerEvent().registerListener(this);

		new SubKommandManager(new Uhc(), true).addSubCommand(new StartGame()).addSubCommand(new SetWorldBordersize())
				.build();

		modifyWorld();

		registerEvents();

		this.scenarioManager.test();
		registerScenarios();
	}

	public void onDisable() {

	}

	private void modifyWorld() {
		Bukkit.setSpawnRadius(0);
		Bukkit.setDefaultGameMode(GameMode.SURVIVAL);

		World world = Bukkit.getWorld(Config.WORLD_NAME);

		world.setPVP(true);
		world.setAmbientSpawnLimit(0);
		world.setDifficulty(Difficulty.NORMAL);
	}

	private void registerEvents() {
		PluginManager pluginManager = getServer().getPluginManager();

		// Events
		pluginManager.registerEvents(new GameComplete(), this);
		pluginManager.registerEvents(new GameStart(), this);
		pluginManager.registerEvents(new GameWin(), this);
		pluginManager.registerEvents(new GraceEnd(), this);

		// Game > Listeners
		pluginManager.registerEvents(new BecomeSpectator(), this);
		pluginManager.registerEvents(new PlayerDeathWin(), this);
		pluginManager.registerEvents(new PlayerJoinGame(), this);
		pluginManager.registerEvents(new PlayerLeaveGame(), this);
		pluginManager.registerEvents(new StopPlayerDamagingPlayer(), this);
		pluginManager.registerEvents(new StopPlayerDamagingPlayerWithBow(), this);
		pluginManager.registerEvents(new PlayerChat(), this);
		pluginManager.registerEvents(new SpectatorChat(), this);

		// GamePlayer
		pluginManager.registerEvents(new ProfileCreateOnJoin(), this);
		pluginManager.registerEvents(new ProfileRemoveOnLeave(), this);
		pluginManager.registerEvents(new ProfilePlayerDeath(), this);

		// GamePlayer Score
		pluginManager.registerEvents(new PlayerKillPointIncrease(), this);
		pluginManager.registerEvents(new GappleEat(), this);

		// Group
		pluginManager.registerEvents(new PlayerChatInGroup(), this);
		pluginManager.registerEvents(new RemoveFromGroupOnLeave(), this);
		pluginManager.registerEvents(new PlayerDamageOtherMember(), this);
		pluginManager.registerEvents(new PlayerShootOtherMember(), this);

		// world
		pluginManager.registerEvents(new PlayerJoinMessage(), this);
		pluginManager.registerEvents(new PlayerLeaveMessage(), this);
		pluginManager.registerEvents(new NoWitherSpawn(), this);
		pluginManager.registerEvents(new NoWeather(), this);
		pluginManager.registerEvents(new CustomWhitelistMessage(), this);

		// world > QoG
		pluginManager.registerEvents(new BowSound(), this);
		pluginManager.registerEvents(new PotionRemove(), this);
		pluginManager.registerEvents(new ArmourBreak(), this);

	}

	private void registerScenarios() {
		PluginManager pluginManager = getServer().getPluginManager();

		this.scenarioManager.getScenarios().forEach(scenario -> {
			Console.SUCCESS.log("Loaded in the Scenario: '" + prettyEnum(scenario.name()) + "'");
			scenario.registerListeners(pluginManager, this);
		});
	}

	private String prettyEnum(String string) {
		string = string.toLowerCase();
		string = string.replace("_", " ");

		if (string.contains(" ")) {
			StringBuilder finalString = new StringBuilder();
			String[] spl = string.split(" ");

			for (int i = 0; i < spl.length; i++) {
				String fixed = spl[i].substring(0, 1).toUpperCase() + spl[i].substring(1);
				finalString.append(i == 0 ? fixed : " " + fixed);
			}

			return finalString.toString();
		}
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

}
