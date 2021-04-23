package by.alekseyshysh.task3.entity;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.impl.FigureParameter;
import by.alekseyshysh.task3.util.IdGenerator;

public class FigureFactory {

	private FigureFactory() {
	}

	// TODO null reference or multiple return?
	public static AbstractFigure newInstance(FigureParameter figureParameter) throws FiguresException {
		AbstractFigure figure = null;
		String figureName = figureParameter.getStringParameter("figureName");
		switch (figureName) {
		case ("RegularPolygon"):
			figure = createRegularPolygon(
					figureParameter.getDoubleParameter("regularPolygonPointX"), 
					figureParameter.getDoubleParameter("regularPolygonPointY"),
					figureParameter.getDoubleParameter("regularPolygonPointZ"),
					figureParameter.getIntegerParameter("regularPolygonSidesCount"),
					figureParameter.getDoubleParameter("regularPolygonSideLength")
					);
			break;
		case ("RegularPyramid"):
			figure = createRegularPyramid(
					figureParameter.getDoubleParameter("regularPolygonPointX"), 
					figureParameter.getDoubleParameter("regularPolygonPointY"),
					figureParameter.getDoubleParameter("regularPolygonPointZ"),
					figureParameter.getIntegerParameter("regularPolygonSidesCount"),
					figureParameter.getDoubleParameter("regularPolygonSideLength"),
					figureParameter.getDoubleParameter("regularPyramidHeight")
					);
			break;
		default:
			throw new FiguresException("No such figure: " + figureName);
		}
		figure.setId(IdGenerator.generateNextId());
		figure.setName(figureName);
		return figure;
	}
	
	private static AbstractFigure createRegularPolygon(double x, double y, double z, int sidesCount, double sideLength) {
		return new RegularPolygon(new Point(x,y,z), sidesCount, sideLength);
	}
	
	private static AbstractFigure createRegularPyramid(double x, double y, double z, int sidesCount, double sideLength, double height) {
		return new RegularPyramid(new RegularPolygon(new Point(x,y,z), sidesCount, sideLength), height);
	}
	
}
