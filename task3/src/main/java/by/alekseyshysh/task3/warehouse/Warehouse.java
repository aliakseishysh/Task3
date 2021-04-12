package by.alekseyshysh.task3.warehouse;

import java.util.HashMap;
import java.util.Map;

import by.alekseyshysh.task3.exception.FiguresException;

public class Warehouse {

	// TODO implement class
	// Площади, Объемы,Периметры фигур должны храниться в объекте класса-Warehouse
	// Любое изменение параметра фигуры должно вызывать пересчет соответствующих
	// значений
	// в классе-Warehouse. Для решения данной задачи использовать паттерны
	// Observer(можно использовать FlowAPI) и
	// Singleton(потокобезопасные варианты использовать запрещено).

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

	public void putParametersRegularPyramid(long id, double area, double perimeter) {
	}

	public void putParametersRegularPolygon(long id, double sideFacesArea, double volume) {
	}

	public void updateParametersRegularPyramid(long id, double area, double perimeter) {
	}

	public void updateParametersRegularPolygon(long id, double sideFacesArea, double volume) {
	}

	public boolean containsKeyRegularPyramid(Long key) {
		return regularPyramidMap.containsKey(key);
	}
	
	public boolean containsKeyRegularPolygon(Long key) {
		return regularPolygonMap.containsKey(key);
	}

}
