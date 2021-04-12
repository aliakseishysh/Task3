package by.alekseyshysh.task3.service.impl;

import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.PyramidCalculationService;

public class PyramidCalculationSerivceImpl implements PyramidCalculationService {

	/*
	 * Для задач 4-8. Cекущие плоскости, фигуры и основания следует ориентировать в
	 * пространстве параллельно осям и плоскостям координат,чтобы формулы вычисления
	 * сечений и параметров фигур не были слишком сложными.
	 */

	@Override
	public double calculateSurfaceArea(RegularPyramid pyramid) {
		RegularPolygon polygon = pyramid.getBase();
		int sidesCount = polygon.getSideCount();
		double sideLength = polygon.getSideLength();
		double baseArea = calculateRegularPolygonArea(sidesCount, sideLength);
		double height = pyramid.getHeight();
		double radius = calulateInscribedCircleRadius(sidesCount, sideLength);
		double apothem = calculateRegularPyramidApothem(height, radius);
		double perimeter = calculateRegularPolygonPerimeter(sideLength, sidesCount);
		double resultArea = baseArea + calculateRegularPyramidSideFacesArea(apothem, perimeter);
		return resultArea;
	}

	@Override
	public double calculateVolume(RegularPyramid pyramid) {
		RegularPolygon polygon = pyramid.getBase();
		int sidesCount = polygon.getSideCount();
		double sideLength = polygon.getSideLength();
		double baseArea = calculateRegularPolygonArea(sidesCount, sideLength);
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
		double areaUp = calculateTruncatedPyramidUpperBaseArea(
				calculateRegularPolygonArea(polygon.getSideCount(), polygon.getSideLength()), heightDown, heightUp);
		double volumeUp = calculateRegularPyramidVolume(areaUp, heightUp);
		double volumeDown = volumePyramidFull - volumeUp;
		double ratio = volumeUp / volumeDown;
		return ratio;
	}

	private double calculateTruncatedPyramidUpperBaseArea(double downArea, double downHeight, double upHeight) {
		double upArea = downArea * Math.sqrt(downHeight) / Math.sqrt(upHeight);
		return upArea;
	}

	private double calculateRegularPolygonArea(int sidesCount, double sideLength) {
		double area = sidesCount * Math.sqrt(sideLength) / 4 / Math.tan((double) 180 / sidesCount);
		return area;
	}

	private double calulateInscribedCircleRadius(int sidesCount, double sideLength) {
		double radius = sideLength / 2 / Math.tan((double) 180 / sidesCount);
		return radius;
	}

	private double calculateRegularPyramidApothem(double height, double radius) {
		double apothem = Math.hypot(height, radius);
		return apothem;
	}

	private double calculateRegularPolygonPerimeter(double sideLength, int sidesCount) {
		double perimeter = sideLength * sidesCount;
		return perimeter;
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
