package by.alekseyshysh.task3.parser.impl;

import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.FigureParser;

public class FigureParserImpl implements FigureParser {

	private static final String SEMICOLON = ";";
	private static final String COLON = ":";
	private static final String COMMA = ",";

	public FigureParameter createParameters(String figure) throws FiguresException {
		FigureParameter figureParameter = new FigureParameter();
		String[] figureInfo = figure.split(COLON);
		switch (figureInfo[0]) {
		case (Figure.REGULAR_POLYGON):
			setRegularPolygonParameters(figureInfo, figureParameter);
			break;
		case (Figure.REGULAR_PYRAMID):
			setRegularpPyramidParameters(figureInfo, figureParameter);
			break;
		default:
			throw new FiguresException("No such figure: " + figureInfo[0]);
		}
		return figureParameter;
	}

	private void setRegularPolygonParameters(String[] figureInfo, FigureParameter figureParameter) {
		figureParameter.addStringParameter(ParameterKey.FIGURE_NAME, figureInfo[0]);
		String[] figureParameters = figureInfo[1].split(SEMICOLON);
		String[] polygonPoint = figureParameters[0].split(COMMA);
		double regularPolygonPointX = Double.parseDouble(polygonPoint[0]);
		figureParameter.addDoubleParameter(ParameterKey.REGULAR_POLYGON_POINT_X, regularPolygonPointX);
		double regularPolygonPointY = Double.parseDouble(polygonPoint[1]);
		figureParameter.addDoubleParameter(ParameterKey.REGULAR_POLYGON_POINT_Y, regularPolygonPointY);
		double regularPolygonPointZ = Double.parseDouble(polygonPoint[2]);
		figureParameter.addDoubleParameter(ParameterKey.REGULAR_POLYGON_POINT_Z, regularPolygonPointZ);
		int regularPolygonSidesCount = Integer.parseInt(figureParameters[1]);
		figureParameter.addIntegerParameter(ParameterKey.REGULAR_POLYGON_SIDES_COUNT, regularPolygonSidesCount);
		double regularPolygonSideLength = Double.parseDouble(figureParameters[2]);
		figureParameter.addDoubleParameter(ParameterKey.REGULAR_POLYGON_SIDE_LENGTH, regularPolygonSideLength);
	}
	
	private void setRegularpPyramidParameters(String[] figureInfo, FigureParameter figureParameter) {
		setRegularPolygonParameters(figureInfo, figureParameter);
		String[] figureParameters = figureInfo[1].split(SEMICOLON);
		double regularPyramidHeight= Double.parseDouble(figureParameters[3]);
		figureParameter.addDoubleParameter(ParameterKey.REGULAR_PYRAMID_HEIGHT, regularPyramidHeight);
	}

}
