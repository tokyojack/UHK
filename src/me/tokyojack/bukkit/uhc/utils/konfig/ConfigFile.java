package me.tokyojack.mcmarket.uhc.utils.konfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigFile {

	private Map<String, Object> configValues = new HashMap<String, Object>();
	private String configName;

	public ConfigFile(String configName) {
		this.configName = configName;
	}

	/**
	 * Sets a empty <code>String</code> value.
	 *
	 * @param String
	 *            Where to set the value.
	 */
	public ConfigFile setString(String configLocation) {
		this.configValues.put(configLocation, "");
		return this;
	}

	/**
	 * Sets a <code>String</code> value.
	 *
	 * @param String
	 *            Where to set the value.
	 * @param String
	 *            The value.
	 */
	public ConfigFile setString(String configLocation, String value) {
		this.configValues.put(configLocation, value);
		return this;
	}

	/**
	 * Sets a <code>Boolean</code> value.
	 *
	 * @param String
	 *            Where to set the value.
	 * @param Boolean
	 *            The value.
	 */
	public ConfigFile setBoolean(String configLocation, boolean value) {
		this.configValues.put(configLocation, value);
		return this;
	}

	/**
	 * Sets a <code>Integer</code> with the value of 0.
	 *
	 * @param String
	 *            Where to set the value.
	 */
	public ConfigFile setInteger(String configLocation) {
		this.configValues.put(configLocation, 0);
		return this;
	}

	/**
	 * Sets a <code>Integer</code> value.
	 *
	 * @param String
	 *            Where to set the value.
	 * @param Integer
	 *            The value.
	 */
	public ConfigFile setInteger(String configLocation, int value) {
		this.configValues.put(configLocation, value);
		return this;
	}

	/**
	 * Sets a <code>Double</code> with the value of 0.0.
	 *
	 * @param String
	 *            Where to set the value.
	 */
	public ConfigFile setDouble(String configLocation) {
		this.configValues.put(configLocation, 0.0);
		return this;
	}

	/**
	 * Sets a <code>Double</code> value.
	 *
	 * @param String
	 *            Where to set the value.
	 * @param Integer
	 *            The value.
	 */
	public ConfigFile setDouble(String configLocation, double value) {
		this.configValues.put(configLocation, value);
		return this;
	}

	/**
	 * Sets a empty <code>ArrayList<String></code>.
	 *
	 * @param String
	 *            Where to set the value.
	 */
	public ConfigFile setArray(String configLocation) {
		this.configValues.put(configLocation, new ArrayList<String>());
		return this;
	}

	/**
	 * Sets a <code>ArrayList<String></code> value.
	 *
	 * @param String
	 *            Where to set the value.
	 * @param ArrayList<String>
	 *            The value.
	 */
	public ConfigFile setArray(String configLocation, ArrayList<String> value) {
		this.configValues.put(configLocation, value);
		return this;
	}

	/**
	 * Sets a <code>Object<String></code> value.
	 *
	 * @param String
	 *            Where to set the value.
	 * @param Object
	 *            The value.
	 */
	public ConfigFile set(String configLocation, Object value) {
		this.configValues.put(configLocation, value);
		return this;
	}

	/**
	 * Returns the ConfigValues.
	 */
	public Map<String, Object> getConfigValues() {
		return this.configValues;
	}

	/**
	 * Returns the ConfigName.
	 */
	public String getConfigName() {
		return this.configName;
	}
}
