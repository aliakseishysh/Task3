package by.alekseyshysh.task3.factory;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.entity.Point;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.reader.ShapeReader;
import by.alekseyshysh.task3.reader.impl.ShapeReaderImpl;

public class FigureFactoryTest {

	private ShapeReader shapeReader = new ShapeReaderImpl();

	@Test
	public void factoryRegularPyramidTest() throws FiguresException {
		RegularPyramid expected = new RegularPyramid(new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0), 5.0);
		RegularPyramid actual = (RegularPyramid) FigureFactory.newInstance("RegularPyramid:0.0,0.0,0.0;4;1.0;5.0");
		System.out.println(expected.toString());
		System.out.println(actual.toString());
		Assert.assertEquals(expected.equals(actual), true);
	}
	
	@Test
	public void factoryRegularPolygonTest() throws FiguresException {
		RegularPolygon expected = new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0);
		RegularPolygon actual = (RegularPolygon) FigureFactory.newInstance("RegularPolygon:0.0,0.0,0.0;4;1.0");
		System.out.println(expected.toString());
		System.out.println(actual.toString());
		Assert.assertEquals(expected.equals(actual), true);
	}
}
