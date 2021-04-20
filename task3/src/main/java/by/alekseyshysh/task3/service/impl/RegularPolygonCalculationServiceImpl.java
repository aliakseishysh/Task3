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

	@Override
	public double calculateArea(RegularPolygon polygon) {
		int sidesCount = polygon.getSideCount();
		double sideLength = polygon.getSideLength();
		double area = sidesCount * Math.sqrt(sideLength) / 4 / Math.tan((double) 180 / sidesCount);
		return area;
	}
	
	@Override
	public double calulateInscribedCircleRadius(RegularPolygon polygon) {
		int sidesCount = polygon.getSideCount();
		double sideLength = polygon.getSideLength();
		double radius = sideLength / 2 / Math.tan((double) 180 / sidesCount);
		return radius;
	}
}
