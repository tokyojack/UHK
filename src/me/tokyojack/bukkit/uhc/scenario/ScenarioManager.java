package me.tokyojack.mcmarket.uhc.scenario;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import me.tokyojack.mcmarket.uhc.scenario.objects.Scenario;

//Maybe put "Scenario" enum in object package?
@Getter
public class ScenarioManager {

	private List<Scenario> scenarios;

	public ScenarioManager() {
		this.scenarios = new ArrayList<Scenario>();
	}

	public void test() {
		for (Scenario scenario : Scenario.values())
			this.scenarios.add(scenario);
	}

	public boolean containsScenario(Scenario scenario) {
		return this.scenarios.contains(scenario);
	}

}
