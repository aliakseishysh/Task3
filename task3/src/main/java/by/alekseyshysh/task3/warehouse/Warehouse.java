package by.alekseyshysh.task3.warehouse;

import java.util.HashMap;
import java.util.Map;

import by.alekseyshysh.task3.exception.FiguresException;

public class Warehouse {

	private static final Warehouse instance = new Warehouse();
	private final Map<Long, RegularPolygonParameter> regularPolygonMap = new HashMap<>();
	private final Map<Long, RegularPyramidParameter> regularPyramidMap = new HashMap<>();

	private Warehouse() {
	}

	public static Warehouse getInstance() {
		return instance;
	}
	
	public RegularPolygonParameter getRegularPolygonParameter(long id) throws FiguresException {
		RegularPolygonParameter parameter = instance.regularPolygonMap.get(id);
		if (parameter == null) {
			throw new FiguresException("No such element with id: " + id);
		}
		return new RegularPolygonParameter(parameter);
	}
	
	public RegularPyramidParameter getRegularPyramidParameter(long id) throws FiguresException {
		RegularPyramidParameter parameter = instance.regularPyramidMap.get(id);
		if (parameter == null) {
			throw new FiguresException("No such element with id: " + id);
		}
		return new RegularPyramidParameter(parameter);
	}

	public void putParametersRegularPyramid(long id, double perimeter, double sideFacesArea, double volume) {
		RegularPyramidParameter parameter = new RegularPyramidParameter();
		parameter.setPerimeter(perimeter);
		parameter.setSideFacesArea(sideFacesArea);
		parameter.setVolume(volume);
		instance.regularPyramidMap.put(id, parameter);
	}

	public void putParametersRegularPolygon(long id, double area, double perimeter) {
		RegularPolygonParameter parameter = new RegularPolygonParameter();
		parameter.setArea(area);
		parameter.setPerimeter(perimeter);
		instance.regularPolygonMap.put(id, parameter);
	}

	public void updateParametersRegularPyramid(long id, double perimeter, double sideFacesArea, double volume) throws FiguresException {
		RegularPyramidParameter parameter = regularPyramidMap.get(id);
		if (parameter == null) {
			throw new FiguresException("No such element with id: " + id);
		}
		parameter.setPerimeter(perimeter);
		parameter.setSideFacesArea(sideFacesArea);
		parameter.setVolume(volume);
	}

	public void updateParametersRegularPolygon(long id, double area, double perimeter) throws FiguresException {
		RegularPolygonParameter parameter = regularPolygonMap.get(id);
		if (parameter == null) {
			throw new FiguresException("No such element with id: " + id);
		}
		parameter.setArea(area);
		parameter.setPerimeter(perimeter);
	}

	public boolean containsKeyRegularPyramid(Long key) {
		return regularPyramidMap.containsKey(key);
	}
	
	public boolean containsKeyRegularPolygon(Long key) {
		return regularPolygonMap.containsKey(key);
	}

}
