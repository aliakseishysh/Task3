package by.alekseyshysh.task3.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.FigureParser;
import by.alekseyshysh.task3.parser.impl.FigureParameter;
import by.alekseyshysh.task3.parser.impl.FigureParserImpl;

/**
 * You should run all test together in this class because of the static IdGenerator 
 * @author alekseyshysh
 *
 */

public class FigureFactoryTest {

	@Test
	public void factoryRegularPolygonTest() throws FiguresException {
		RegularPolygon expected = new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0);
		expected.setId(0);
		expected.setName("RegularPolygon");
		FigureParser parser = new FigureParserImpl();
		FigureParameter figureParameter = parser.createParameters("RegularPolygon:0.0,0.0,0.0;4;1.0");
		FigureFactory factory = new PlanimetricFigureFactory();
		RegularPolygon actual = (RegularPolygon) factory.newInstance(figureParameter);
		Assert.assertEquals(expected.equals(actual), true);
	}
	
	@Test
	public void factoryRegularPyramidTest() throws FiguresException {
		RegularPyramid expected = new RegularPyramid(new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0), 5.0);
		expected.setId(1);
		expected.setName("RegularPyramid");
		FigureParser parser = new FigureParserImpl();
		FigureParameter figureParameter = parser.createParameters("RegularPyramid:0.0,0.0,0.0;4;1.0;5.0"); 
		FigureFactory factory = new StereometricFigureFactory();
		RegularPyramid actual = (RegularPyramid) factory.newInstance(figureParameter);
		Assert.assertEquals(expected.equals(actual), true);
	}
}
