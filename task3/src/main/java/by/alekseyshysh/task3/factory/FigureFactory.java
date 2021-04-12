package by.alekseyshysh.task3.factory;

import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.entity.Point;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.validator.FigureShapeValidator;

public class FigureFactory {
	
	private FigureFactory() {
	}

	public static Figure newInstance(String line) throws FiguresException {
		String[] figureInfo = line.split(":");
		switch (figureInfo[0]) {
		case ("RegularPolygon"):
			String[] polygonInfo = figureInfo[1].split(";");
			return createRegularPolygon(polygonInfo);
		case ("RegularPyramid"):
			String[] regularPyramidInfo = figureInfo[1].split(";");
			return createRegularPyramid(regularPyramidInfo);
		default:
			throw new FiguresException("No such figure: " + line);
		}
	}
	
	private static Figure createRegularPolygon(String[] polygonInfo) {
		String[] pointInfo = polygonInfo[0].split(",");
		Point point = new Point(Double.parseDouble(pointInfo[0]), Double.parseDouble(pointInfo[1]),
				Double.parseDouble(pointInfo[2]));
		int sidesCount = Integer.parseInt(polygonInfo[1]);
		double sideLength = Double.parseDouble(polygonInfo[2]);
		return new RegularPolygon(point, sidesCount, sideLength);
	}
	
	private static Figure createRegularPyramid(String[] regularPyramidInfo) throws FiguresException {
		StringBuilder builder = new StringBuilder("RegularPolygon:");
		builder.append(regularPyramidInfo[0]);
		builder.append(";");
		builder.append(regularPyramidInfo[1]);
		builder.append(";");
		builder.append(regularPyramidInfo[2]);
		String requestLine = builder.toString();
		RegularPolygon polygon = (RegularPolygon) FigureFactory.newInstance(requestLine);
		double height = Double.parseDouble(regularPyramidInfo[3]);
		if (!FigureShapeValidator.isRegularPyramidCorrect(polygon, height)) {
			throw new FiguresException("Can't create pyramid with this values: " + regularPyramidInfo);
		}
		return new RegularPyramid(polygon, height);
	}
	
}
