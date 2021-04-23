package by.alekseyshysh.task3.entity;

import java.util.Map;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.validator.FigureShapeValidator;

public class FigureFactory {

	private static final String SEMICOLON = ";";
	private static final String COLON = ":";
	private static final String COMMA = ",";

	private FigureFactory() {
	}

	public static AbstractFigure newInstance(String line) throws FiguresException {
		String[] figureInfo = line.split(COLON);
		switch (figureInfo[0]) {
		case ("RegularPyramid"):
			String[] regularPyramidInfo = figureInfo[1].split(SEMICOLON);
			return createRegularPyramid(regularPyramidInfo);
		case ("RegularPolygon"):
			String[] polygonInfo = figureInfo[1].split(SEMICOLON);
			return createRegularPolygon(polygonInfo);
		default:
			throw new FiguresException("No such figure: " + line);
		}
	}

	// TODO null reference or multiple return?
	public static AbstractFigure newInstance(Map parameters) throws FiguresException {
		AbstractFigure figure = null;
		String figureName = parameters.get("figureName").toString();
		switch (figureName) {
		case ("RegularPyramid"):
			createRegularPyramid(
					Double.valueOf(parameters.get("regularPolygonPointX").toString()), 
					Double.valueOf(parameters.get("regularPolygonPointY").toString()),
					Double.valueOf(parameters.get("regularPolygonPointZ").toString()),
					Integer.valueOf(parameters.get("regularPolygonsidesCount").toString()),
					Double.valueOf(parameters.get("regularPolygonsideLength").toString()),
					Double.valueOf(parameters.get("regularPyramidHeight").toString())
					);
			break;
		case ("RegularPolygon"):
			createRegularPolygon(
					Double.valueOf(parameters.get("regularPolygonPointX").toString()), 
					Double.valueOf(parameters.get("regularPolygonPointY").toString()),
					Double.valueOf(parameters.get("regularPolygonPointZ").toString()),
					Integer.valueOf(parameters.get("regularPolygonsidesCount").toString()),
					Double.valueOf(parameters.get("regularPolygonsideLength").toString())
					);
			break;
		default:
			throw new FiguresException("No such figure: " + figureName);
		}
		return figure;
	}
	
	private static AbstractFigure createRegularPolygon(double x, double y, double z, int sidesCount, double sideLength) {
		return new RegularPolygon(new Point(x,y,z), sidesCount, sideLength);
	}
	
	private static AbstractFigure createRegularPyramid(double x, double y, double z, int sidesCount, double sideLength, double height) {
		return new RegularPyramid(new RegularPolygon(new Point(x,y,z), sidesCount, sideLength), height);
	}

	private static AbstractFigure createRegularPolygon(String[] polygonInfo) {
		String[] pointInfo = polygonInfo[0].split(COMMA);
		Point point = new Point(Double.parseDouble(pointInfo[0]), Double.parseDouble(pointInfo[1]),
				Double.parseDouble(pointInfo[2]));
		int sidesCount = Integer.parseInt(polygonInfo[1]);
		double sideLength = Double.parseDouble(polygonInfo[2]);
		return new RegularPolygon(point, sidesCount, sideLength);
	}

	private static AbstractFigure createRegularPyramid(String[] regularPyramidInfo) throws FiguresException {
		RegularPolygon polygon = (RegularPolygon) createRegularPolygon(
				new String[] { regularPyramidInfo[0], regularPyramidInfo[1], regularPyramidInfo[2] });
		double height = Double.parseDouble(regularPyramidInfo[3]);
		if (!FigureShapeValidator.isRegularPyramidCorrect(polygon, height)) {
			throw new FiguresException("Can't create pyramid with this values: " + regularPyramidInfo);
		}
		return new RegularPyramid(polygon, height);
	}

}
