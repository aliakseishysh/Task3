package by.alekseyshysh.task3.entity;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.impl.FigureParameter;
import by.alekseyshysh.task3.parser.impl.ParameterKey;
import by.alekseyshysh.task3.util.IdGenerator;

public class StereometricFigureFactory implements FigureFactory {

		public AbstractFigure newInstance(FigureParameter figureParameter) throws FiguresException {
			AbstractFigure figure = null;
			String figureName = figureParameter.getStringParameter(ParameterKey.FIGURE_NAME);
			switch (figureName) {
			case (Figure.REGULAR_PYRAMID):
				figure = createRegularPyramid(
						figureParameter.getDoubleParameter(ParameterKey.REGULAR_POLYGON_POINT_X), 
						figureParameter.getDoubleParameter(ParameterKey.REGULAR_POLYGON_POINT_Y),
						figureParameter.getDoubleParameter(ParameterKey.REGULAR_POLYGON_POINT_Z),
						figureParameter.getIntegerParameter(ParameterKey.REGULAR_POLYGON_SIDES_COUNT),
						figureParameter.getDoubleParameter(ParameterKey.REGULAR_POLYGON_SIDE_LENGTH),
						figureParameter.getDoubleParameter(ParameterKey.REGULAR_PYRAMID_HEIGHT)
						);
				break;
			default:
				throw new FiguresException("No such figure: " + figureName);
			}
			figure.setId(IdGenerator.generateNextId());
			figure.setName(figureName);
			return figure;
		}
		
		private static AbstractFigure createRegularPyramid(double x, double y, double z, int sidesCount, double sideLength, double height) {
			return new RegularPyramid(new RegularPolygon(new Point(x,y,z), sidesCount, sideLength), height);
		}
	
}
