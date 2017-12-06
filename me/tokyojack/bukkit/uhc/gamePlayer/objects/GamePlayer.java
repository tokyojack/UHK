package me.tokyojack.mcmarket.uhc.gamePlayer.objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GamePlayer {

	private String name; // Storing name as it's less resources than an UUID.
	private PlayerState playerState;

	private int kills;
	private int gapplesEaten;
	private int enderpearlThrown;

	public GamePlayer(String name) {
		this.name = name;
		this.playerState = PlayerState.PLAYING;

		this.kills = 0;
		this.gapplesEaten = 0;
		this.enderpearlThrown = 0;
	}

	public void addKill() {
		this.kills++;
	}

	public void addGappleEaten() {
		this.gapplesEaten++;
	}

	public void addEnderpearlThrown() {
		this.enderpearlThrown++;
	}

}
