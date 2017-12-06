package me.tokyojack.mcmarket.uhc.scenario.events.CutClean;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class AnimalDeathDropsCook implements Listener {

	@SuppressWarnings("serial")
	private final Map<EntityType, Material> ANIMALS = new HashMap<EntityType, Material>() {
		{
			put(EntityType.PIG, Material.GRILLED_PORK);
			put(EntityType.COW, Material.COOKED_BEEF);
			put(EntityType.CHICKEN, Material.COOKED_CHICKEN);
			put(EntityType.RABBIT, Material.COOKED_RABBIT);
			put(EntityType.SHEEP, Material.COOKED_MUTTON);
		}
	};

	@EventHandler
	public void blockBreak(EntityDeathEvent event) {
		if (!this.ANIMALS.containsKey(event.getEntityType()))
			return;

		Material cookedItem = this.ANIMALS.get(event.getEntityType());

		event.getDrops().forEach(drop -> drop.setType(cookedItem));
	}

}
