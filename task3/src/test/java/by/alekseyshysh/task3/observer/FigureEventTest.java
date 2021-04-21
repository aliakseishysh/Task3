package by.alekseyshysh.task3.observer;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.entity.FigureFactory;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.entity.RegularPyramidParameter;
import by.alekseyshysh.task3.entity.Warehouse;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.observer.impl.RegularPyramidObserverImpl;
import by.alekseyshysh.task3.service.PyramidCalculationService;
import by.alekseyshysh.task3.service.impl.PyramidCalculationServiceImpl;

public class FigureEventTest {

	@Test
	public void figureEventTest() throws FiguresException {
		RegularPyramid pyramid = (RegularPyramid) FigureFactory.newInstance("RegularPyramid:0.0,0.0,0.0;4;1.0;5.0");
		pyramid.attach(new RegularPyramidObserverImpl());
		Warehouse warehouse = Warehouse.getInstance();
		long id = pyramid.getId();
		PyramidCalculationService calculation = new PyramidCalculationServiceImpl();
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
