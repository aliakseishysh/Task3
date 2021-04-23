package by.alekseyshysh.task3.parser.impl;

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
		case ("RegularPolygon"):
			setRegularPolygonParameters(figureInfo, figureParameter);
			break;
		case ("RegularPyramid"):
			setRegularpPyramidParameters(figureInfo, figureParameter);
			break;
		default:
			throw new FiguresException("No such figure: " + figureInfo[0]);
		}
		return figureParameter;
	}

	private void setRegularPolygonParameters(String[] figureInfo, FigureParameter figureParameter) {
		figureParameter.addStringParameter("figureName", figureInfo[0]);
		String[] figureParameters = figureInfo[1].split(SEMICOLON);
		String[] polygonPoint = figureParameters[0].split(COMMA);
		double regularPolygonPointX = Double.parseDouble(polygonPoint[0]);
		figureParameter.addDoubleParameter("regularPolygonPointX", regularPolygonPointX);
		double regularPolygonPointY = Double.parseDouble(polygonPoint[1]);
		figureParameter.addDoubleParameter("regularPolygonPointY", regularPolygonPointY);
		double regularPolygonPointZ = Double.parseDouble(polygonPoint[2]);
		figureParameter.addDoubleParameter("regularPolygonPointZ", regularPolygonPointZ);
		int regularPolygonSidesCount = Integer.parseInt(figureParameters[1]);
		figureParameter.addIntegerParameter("regularPolygonSidesCount", regularPolygonSidesCount);
		double regularPolygonSideLength = Double.parseDouble(figureParameters[2]);
		figureParameter.addDoubleParameter("regularPolygonSideLength", regularPolygonSideLength);
	}
	
	private void setRegularpPyramidParameters(String[] figureInfo, FigureParameter figureParameter) {
		setRegularPolygonParameters(figureInfo, figureParameter);
		String[] figureParameters = figureInfo[1].split(SEMICOLON);
		double regularPyramidHeight= Double.parseDouble(figureParameters[3]);
		figureParameter.addDoubleParameter("regularPyramidHeight", regularPyramidHeight);
	}

}
