package me.tokyojack.mcmarket.uhc.game.objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

	private GameState gameState;

	public Game() {
		this.gameState = GameState.WAITING;
	}

	public boolean isIngame() {
		return this.gameState.isIngame();
	}

	public BlockedDamage getDamageTakenType() {
		return this.gameState.getBlockedDamage();
	}
}
