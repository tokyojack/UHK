package me.tokyojack.mcmarket.uhc.scenario.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.tokyojack.mcmarket.uhc.scenario.events.BloodDiamonds.HeartRemovedWhenDiamondsMined;
import me.tokyojack.mcmarket.uhc.scenario.events.Bowless.StopBowCraft;
import me.tokyojack.mcmarket.uhc.scenario.events.Bowless.StopBowFromShooting;
import me.tokyojack.mcmarket.uhc.scenario.events.CutClean.AnimalDeathDropsCook;
import me.tokyojack.mcmarket.uhc.scenario.events.CutClean.OreBreakSmelt;
import me.tokyojack.mcmarket.uhc.scenario.events.Diamondless.DiamondOreDropRemove;
import me.tokyojack.mcmarket.uhc.scenario.events.Diamondless.PlayerDropDiamondOnDeath;
import me.tokyojack.mcmarket.uhc.scenario.events.Fireless.PlayerTakeFireDamage;
import me.tokyojack.mcmarket.uhc.scenario.events.Horseless.HorseMount;
import me.tokyojack.mcmarket.uhc.scenario.events.Horseless.HorseTaim;
import me.tokyojack.mcmarket.uhc.scenario.events.Longshot.LongDistanceShot;
import me.tokyojack.mcmarket.uhc.scenario.events.LuckyLeaves.LeaveFadeDropApple;
import me.tokyojack.mcmarket.uhc.scenario.events.NoClean.ProtectionGainWhenKilledPlayer;
import me.tokyojack.mcmarket.uhc.scenario.events.NoFall.PlayerFallDamage;
import me.tokyojack.mcmarket.uhc.scenario.events.Rodless.FishingRodUse;
import me.tokyojack.mcmarket.uhc.scenario.events.Rodless.StopFishingRodCraft;
import me.tokyojack.mcmarket.uhc.scenario.events.Soup.PlayerRightClickMushroomSoup;
import me.tokyojack.mcmarket.uhc.scenario.events.Switcheroo.SwitchPlayerIfShotWithPlayerArrow;
import me.tokyojack.mcmarket.uhc.scenario.events.Swordless.PlayerAttackEntityWithSword;
import me.tokyojack.mcmarket.uhc.scenario.events.TimeBomb.PlaceChestOnDeath;
import me.tokyojack.mcmarket.uhc.scenario.events.TripleOres.OreTripleDropWhenBroken;
import me.tokyojack.mcmarket.uhc.scenario.events.WebCage.PlayerDeathSpawnWebCage;
import me.tokyojack.mcmarket.uhc.utils.ItemBuilder;

@Getter
public enum Scenario {
	CUTCLEAN(new ItemBuilder(Material.IRON_SWORD).setName("Cut clean").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new OreBreakSmelt(), plugin);
			pluginManager.registerEvents(new AnimalDeathDropsCook(), plugin);
		}
	},
	TIMEBOMB(new ItemBuilder(Material.TNT).setName("Time Bomb").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new PlaceChestOnDeath(), plugin);
		}
	},
	DIAMONDLESS(new ItemBuilder(Material.DIAMOND).setName("Diamondless").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new DiamondOreDropRemove(), plugin);
			pluginManager.registerEvents(new PlayerDropDiamondOnDeath(), plugin);
		}
	},
	BOWLESS(new ItemBuilder(Material.BOW).setName("Bowless").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new StopBowCraft(), plugin);
			pluginManager.registerEvents(new StopBowFromShooting(), plugin);
		}
	},
	TRIPLEORE(new ItemBuilder(Material.DIAMOND_ORE).setName("Triple Ore").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new OreTripleDropWhenBroken(), plugin);
		}
	},
	HORSELESS(new ItemBuilder(Material.SADDLE).setName("Horseless").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new HorseMount(), plugin);
			pluginManager.registerEvents(new HorseTaim(), plugin);
		}
	},
	LONGSHOT(new ItemBuilder(Material.ARROW).setName("Longshot").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new LongDistanceShot(), plugin);
		}
	},
	NOFALL(new ItemBuilder(Material.CHAINMAIL_BOOTS).setName("NoFall").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new PlayerFallDamage(), plugin);
		}
	},
	SWITCHEROO(new ItemBuilder(Material.BOW).setName("Switcheroo").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new SwitchPlayerIfShotWithPlayerArrow(), plugin);
		}
	},
	LUCKYLEAVES(new ItemBuilder(Material.LEAVES).setName("Lucky Leaves").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new LeaveFadeDropApple(), plugin);
		}
	},
	FIRELESS(new ItemBuilder(Material.FLINT_AND_STEEL).setName("Fireless").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new PlayerTakeFireDamage(), plugin);
		}
	},
	SOUP(new ItemBuilder(Material.MUSHROOM_SOUP).setName("Soup").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new PlayerRightClickMushroomSoup(), plugin);
		}
	},
	NO_CLEAN(new ItemBuilder(Material.IRON_AXE).setName("No Clean").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new ProtectionGainWhenKilledPlayer(), plugin);
		}
	},
	SWORDLESS(new ItemBuilder(Material.IRON_SWORD).setName("Swordless").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new PlayerAttackEntityWithSword(), plugin);
		}
	},
	RODLESS(new ItemBuilder(Material.FISHING_ROD).setName("Rodless").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new FishingRodUse(), plugin);
			pluginManager.registerEvents(new StopFishingRodCraft(), plugin);
		}
	},
	BLOODDIAMOND(new ItemBuilder(Material.DIAMOND).setName("Blood Diamond").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new HeartRemovedWhenDiamondsMined(), plugin);
		}
	},
	WEBCAGE(new ItemBuilder(Material.WEB).setName("Web Cage").toItemStack()) {
		@Override
		public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
			pluginManager.registerEvents(new PlayerDeathSpawnWebCage(), plugin);
		}
	};

	private ItemStack inventoryItem;

	private Scenario(ItemStack inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	public void registerListeners(PluginManager pluginManager, JavaPlugin plugin) {
		// Should never run
	}

}
