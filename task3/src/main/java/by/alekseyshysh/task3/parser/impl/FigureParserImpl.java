package by.alekseyshysh.task3.parser.impl;

import java.util.HashMap;
import java.util.Map;

import by.alekseyshysh.task3.parser.FigureParser;

public class FigureParserImpl implements FigureParser {

	private static final String SEMICOLON = ";";
	private static final String COLON = ":";
	private static final String COMMA = ",";

	public void createParameters(String figure) {
		Map<Object, Object> parameters = new HashMap<>();
		String[] figureInfo = figure.split(COLON);
		switch (figureInfo[0]) {
		case ("RegularPolygon"):
			String[] point = figureInfo[1].split(COMMA);
			double x = Double.valueOf(point[0]);
			double y = Double.valueOf(point[1]);
			double z = Double.valueOf(point[2]);
			int sidesCount = Integer.valueOf(figureInfo[2]);
			double sideLength = Double.valueOf(figureInfo[3]);
			break;
		default:
			break;
		}
	}

}
