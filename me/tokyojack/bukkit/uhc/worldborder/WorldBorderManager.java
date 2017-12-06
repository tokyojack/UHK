package me.tokyojack.mcmarket.uhc.worldborder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;

import lombok.Getter;
import me.tokyojack.mcmarket.uhc.Config;
import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.KountdownConditional;

@Getter
public class WorldBorderManager {

	private final int STARTING_SIZE = 100;
	private final int SIZE_TO_STOP_AT = 10;

	private final int HOW_OFTEN_BORDER_IS_SHRUNKEN_IN_SECONDS = 10;
	private final int DECRASE_AMOUNT = 10;

	private WorldBorder worldBorder;
	private KountdownConditional worldborderCountdown;

	public WorldBorderManager() {
		World world = Bukkit.getWorld(Config.WORLD_NAME);
		WorldBorder worldBorder = world.getWorldBorder();
		worldBorder.setCenter(new Location(world, 0, 0, 0));
		worldBorder.setWarningDistance(0);
		worldBorder.setWarningTime(0);
		worldBorder.setDamageBuffer(0);

		worldBorder.setSize(this.STARTING_SIZE);

		this.worldBorder = worldBorder;

		this.worldborderCountdown = new KountdownConditional(this.HOW_OFTEN_BORDER_IS_SHRUNKEN_IN_SECONDS,
				UHC.getPlugin()) {

			@Override
			public void tick(int timeLeft) {
				Chat.broadcast("World aborder decreased by " + DECRASE_AMOUNT + " ("
						+ (int) (worldBorder.getSize() - DECRASE_AMOUNT) + ")");
				worldBorder.setSize(worldBorder.getSize() - DECRASE_AMOUNT, 10);
			}

			@Override
			public boolean checkToStop() {
				return SIZE_TO_STOP_AT >= worldBorder.getSize();
			}

			@Override
			public void finished() {
				Chat.broadcast("Border has gotten to it's smallest size");
			}

		};
	}

	public void start() {
		this.worldborderCountdown.start();
	}

	public void stop() {
		this.worldborderCountdown.stop();
	}

}
