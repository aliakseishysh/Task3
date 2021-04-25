package by.alekseyshysh.task3.parser.impl;

import java.util.HashMap;
import java.util.Map;

public class FigureParameter {
	
	private Map<String, Double> doubleParameter = new HashMap<>();
	private Map<String, Integer> integerParameter = new HashMap<>();
	private Map<String, String> stringParameter = new HashMap<>();
	
	public Double getDoubleParameter(String key) {
		return doubleParameter.get(key);
	}
	
	public Integer getIntegerParameter(String key) {
		return integerParameter.get(key);
	}
	
	public String getStringParameter(String key) {
		return stringParameter.get(key);
	}
	
	public void addDoubleParameter(String key, Double value) {
		doubleParameter.put(key, value);
	}
	
	public void addIntegerParameter(String key, Integer value) {
		integerParameter.put(key, value);
	}

	public void addStringParameter(String key, String value) {
		stringParameter.put(key, value);
	}
	
}
