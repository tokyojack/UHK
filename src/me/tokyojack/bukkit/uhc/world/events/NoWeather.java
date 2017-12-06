package me.tokyojack.mcmarket.uhc.world.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class NoWeather implements Listener {

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent event) {
		if (!event.toWeatherState())
			return;

		event.setCancelled(true);
	}
}
