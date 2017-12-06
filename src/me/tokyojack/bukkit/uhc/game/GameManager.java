package me.tokyojack.mcmarket.uhc.game;

import lombok.Getter;
import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.game.objects.Game;
import me.tokyojack.mcmarket.uhc.game.objects.GameState;
import me.tokyojack.mcmarket.uhc.utils.Countdown;

@Getter
public class GameManager {

	private Game game;

	public GameManager() {
		this.game = new Game();
	}

	public void startGrace() {
		UHC.getPlugin().getGameManager().getGame().setGameState(GameState.GRACE);
		Countdown.GRACE.start();
	}

	public void startGame() {
		this.game.setGameState(GameState.STARTING);
		Countdown.STARTING.start();
	}

	public void endGame() {
		this.game.setGameState(GameState.ENDING);
		Countdown.ENDING.start();
	}
}
