package me.tokyojack.mcmarket.uhc.group.objects;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import me.tokyojack.mcmarket.uhc.utils.Console;

@Setter
@Getter
public class Group {

	//Using their name for less data usage
	private List<String> members;

	public Group() {
		this.members = new ArrayList<String>();
	}
	
	public void addMember(String name){
		Console.INFO.log(name + " added to group");
		this.members.add(name);
	}
	
	public void removeMember(String name){
		this.members.remove(name);
	}
	
	public int getSize(){
		return this.members.size();
	}
}
