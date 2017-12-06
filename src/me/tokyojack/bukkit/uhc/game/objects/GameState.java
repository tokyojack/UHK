package me.tokyojack.mcmarket.uhc.game.objects;

import lombok.Getter;

@Getter
public enum GameState {
	WAITING(false, BlockedDamage.ALL),
	STARTING(true, BlockedDamage.ALL),
	GRACE(true, BlockedDamage.PLAYER),
	FIGHTNING(true, BlockedDamage.NONE),
	DEATHMATCH(true, BlockedDamage.NONE),
	ENDING(true, BlockedDamage.ALL);

	private boolean isIngame;
	private BlockedDamage blockedDamage;

	private GameState(boolean isIngame, BlockedDamage blockedDamage) {
		this.isIngame = isIngame;
		this.blockedDamage = blockedDamage;
	}

}
