package me.tokyojack.mcmarket.uhc.group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import lombok.Getter;
import me.tokyojack.mcmarket.uhc.Config;
import me.tokyojack.mcmarket.uhc.group.objects.Group;
import me.tokyojack.mcmarket.uhc.utils.Console;

@Getter
public class GroupManager {

	private List<Group> groups;

	public GroupManager() {
		this.groups = new ArrayList<Group>();

		for (int i = 0; i < Config.MAX_TOTAL_GROUP_AMOUNT; i++) {
			this.groups.add(new Group());
		}

	}

	public Group getGroupByPlayerName(String name) {
		return this.groups.stream().filter(group -> group.getMembers().contains(name)).findFirst().orElse(null);
	}

	public void removePlayerFromGroup(String name) {
		Group group = getGroupByPlayerName(name);
		Console.ERROR.log(group.getMembers().toString());
		group.removeMember(name);
		if (group.getSize() <= 0)
			this.groups.remove(group);
	}

	public int getNumberOfGroupsLeft() {
		return this.groups.size();
	}

	public Group getWinningGroup() {
		return this.groups.get(0); // Gets only group left
	}

	public boolean isInAGroup(String playerName) {
		Group group = getGroupByPlayerName(playerName);
		if (group == null) // Never found a group
			return false;

		return true;
	}

	public boolean isInSameGroup(String player1Name, String player2Name) {
		Group group = getGroupByPlayerName(player1Name);
		if (group == null) // Never found a group
			return false;

		return group.getMembers().contains(player2Name);
	}

	public void addPlayerToOpenGroup(String name) {
		Group openGroup = this.groups.stream()
				.filter(group -> group.getMembers().size() < Config.MAX_GROUP_MEMBER_AMOUNT).findFirst().orElse(null);
		openGroup.addMember(name);
	}

	public List<Player> getAllPlayers() {
		List<List<String>> groupUsernames = this.groups.stream().map(group -> group.getMembers())
				.collect(Collectors.toList());

		List<Player> finalPlayers = new ArrayList<Player>();

		for (int i = 0; i < groupUsernames.size(); i++) {
			groupUsernames.get(0).forEach(username -> finalPlayers.add(Bukkit.getPlayer(username)));
		}
		return finalPlayers;
	}

}
