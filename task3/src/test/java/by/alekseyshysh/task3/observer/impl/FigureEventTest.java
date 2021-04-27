package by.alekseyshysh.task3.observer.impl;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.entity.FigureFactory;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.entity.RegularPyramidParameter;
import by.alekseyshysh.task3.entity.StereometricFigureFactory;
import by.alekseyshysh.task3.entity.Warehouse;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.FigureParser;
import by.alekseyshysh.task3.parser.impl.FigureParameter;
import by.alekseyshysh.task3.parser.impl.FigureParserImpl;
import by.alekseyshysh.task3.service.RegularPyramidCalculationService;
import by.alekseyshysh.task3.service.impl.RegularPyramidCalculationServiceImpl;

public class FigureEventTest {

	@Test
	public void figureEventTest() throws FiguresException {
		FigureParser parser = new FigureParserImpl();
		FigureParameter figureParameter = parser.createParameters("RegularPyramid:0.0,0.0,0.0;4;1.0;5.0"); 
		FigureFactory factory = new StereometricFigureFactory();
		RegularPyramid pyramid = (RegularPyramid) factory.newInstance(figureParameter);
		pyramid.attach(new RegularPyramidObserverImpl());
		Warehouse warehouse = Warehouse.getInstance();
		long id = pyramid.getId();
		RegularPyramidCalculationService calculation = new RegularPyramidCalculationServiceImpl();
		double perimeter = calculation.calculatePerimeter(pyramid);
		double surfaceArea = calculation.calculateSurfaceArea(pyramid);
		double volume = calculation.calculateVolume(pyramid);
		warehouse.putParametersRegularPyramid(id, perimeter, surfaceArea, volume);
		pyramid.setHeight(10.0);
		double expected = calculation.calculatePerimeter(pyramid);
		RegularPyramidParameter pyramidParameter = warehouse.getRegularPyramidParameter(id);
		double actual = pyramidParameter.getPerimeter();
		Assert.assertEquals(expected, actual, 0.0000000001);
	}

}
