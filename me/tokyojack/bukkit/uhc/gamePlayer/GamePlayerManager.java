package me.tokyojack.mcmarket.uhc.gamePlayer;

import java.util.ArrayList;
import java.util.List;

import me.tokyojack.mcmarket.uhc.gamePlayer.objects.GamePlayer;

public class GamePlayerManager {

	private List<GamePlayer> gamePlayers;
	private List<GamePlayer> deadGamePlayers;

	public GamePlayerManager() {
		this.gamePlayers = new ArrayList<GamePlayer>();
		this.deadGamePlayers = new ArrayList<GamePlayer>();
	}

	public void addPlayer(String name) {
		this.gamePlayers.add(new GamePlayer(name));
	}

	// TODO rename?
	public void removeGamePlayer(String name) {
		GamePlayer player = this.gamePlayers.stream().filter(gamePlayer -> gamePlayer.getName().equalsIgnoreCase(name))
				.findFirst().orElse(null);

		this.deadGamePlayers.add(player);
		this.gamePlayers.remove(player);

	}

	public GamePlayer getGamePlayer(String name) {
		return this.gamePlayers.stream().filter(gamePlayer -> gamePlayer.getName().equalsIgnoreCase(name)).findFirst()
				.orElse(null);
	}

	public GamePlayer getDeadGamePlayerName(String name) {
		return this.deadGamePlayers.stream().filter(gamePlayer -> gamePlayer.getName().equalsIgnoreCase(name))
				.findFirst().orElse(null);
	}
	
	public List<GamePlayer> getAlivePlayers() {
		return this.gamePlayers;
	}

	public List<GamePlayer> getDeadPlayers() {
		return this.deadGamePlayers;
	}

	public boolean isDead(String name) {
		return getGamePlayer(name) == null;
	}

	public void saveAll() {
		// for(GamePlayer gamePlayer : this.gamePlayers){
		//// boolean didWin = gamePlayer.isWonGame();
		//// boolean didDie = gamePlayer.isDead();
		//// int kills = gamePlayer.getKills();
		// }
	}

}
