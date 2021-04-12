package by.alekseyshysh.task3.service.impl;

import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.service.RegularPolygonCalculationService;

public class RegularPolygonCalculationServiceImpl implements RegularPolygonCalculationService {

	@Override
	public double calculatePerimeter(RegularPolygon polygon) {
		int sideCount = polygon.getSideCount();
		double sideLength = polygon.getSideLength();
		double result = sideLength * sideCount;
		return result;
	}
}
