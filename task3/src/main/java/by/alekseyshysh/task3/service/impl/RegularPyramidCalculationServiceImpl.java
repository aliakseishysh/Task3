package by.alekseyshysh.task3.service.impl;

import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.RegularPyramidCalculationService;
import by.alekseyshysh.task3.service.RegularPolygonCalculationService;

public class RegularPyramidCalculationServiceImpl implements RegularPyramidCalculationService {

	@Override
	public double calculatePerimeter(RegularPyramid regularPyramid) {
		RegularPolygonCalculationService regularPolygonCalculationService = new RegularPolygonCalculationServiceImpl();
		RegularPolygon polygon = regularPyramid.getBase();
		double radius = regularPolygonCalculationService.calulateInscribedCircleRadius(polygon);
		double height = regularPyramid.getHeight();
		double edge = Math.hypot(radius, height);
		double basePerimeter = regularPolygonCalculationService.calculatePerimeter(polygon);
		int sidesCount = polygon.getSideCount();
		double perimeter = basePerimeter + sidesCount * edge;
		return perimeter;

	}

	@Override
	public double calculateSurfaceArea(RegularPyramid pyramid) {
		RegularPolygonCalculationService regularPolygonCalculationService = new RegularPolygonCalculationServiceImpl();
		RegularPolygon polygon = pyramid.getBase();
		double baseArea = regularPolygonCalculationService.calculateArea(polygon);
		double height = pyramid.getHeight();
		double radius = regularPolygonCalculationService.calulateInscribedCircleRadius(polygon);
		double apothem = calculateRegularPyramidApothem(height, radius);
		double perimeter = regularPolygonCalculationService.calculatePerimeter(polygon);
		double resultArea = baseArea + calculateRegularPyramidSideFacesArea(apothem, perimeter);
		return resultArea;
	}

	@Override
	public double calculateVolume(RegularPyramid pyramid) {
		RegularPolygonCalculationService regularPolygonCalculationService = new RegularPolygonCalculationServiceImpl();
		RegularPolygon polygon = pyramid.getBase();
		double baseArea = regularPolygonCalculationService.calculateArea(polygon);
		double height = pyramid.getHeight();
		double resultVolume = calculateRegularPyramidVolume(baseArea, height);
		return resultVolume;
	}

	@Override
	public double calculateDissectionVolumesRatio(RegularPyramid pyramid, double dissectionHeight) {
		double heightDown = dissectionHeight;
		RegularPolygon polygon = pyramid.getBase();
		double heightUp = pyramid.getHeight() - heightDown;
		double volumePyramidFull = calculateVolume(pyramid);
		RegularPolygonCalculationService regularPolygonCalculationService = new RegularPolygonCalculationServiceImpl();
		double areaUp = calculateTruncatedPyramidUpperBaseArea(regularPolygonCalculationService.calculateArea(polygon),
				heightDown, heightUp);
		double volumeUp = calculateRegularPyramidVolume(areaUp, heightUp);
		double volumeDown = volumePyramidFull - volumeUp;
		double ratio = volumeUp / volumeDown;
		return ratio;
	}

	private double calculateTruncatedPyramidUpperBaseArea(double downArea, double downHeight, double upHeight) {
		double upArea = downArea * Math.sqrt(downHeight) / Math.sqrt(upHeight);
		return upArea;
	}

	private double calculateRegularPyramidApothem(double height, double radius) {
		double apothem = Math.hypot(height, radius);
		return apothem;
	}

	private double calculateRegularPyramidSideFacesArea(double apothem, double perimeter) {
		double area = apothem * perimeter / 2;
		return area;
	}

	private double calculateRegularPyramidVolume(double baseArea, double height) {
		double volume = baseArea * height / 3;
		return volume;
	}

}
