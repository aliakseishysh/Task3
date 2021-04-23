package by.alekseyshysh.task3.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.entity.FigureFactory;
import by.alekseyshysh.task3.entity.Point;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.reader.FigureReader;
import by.alekseyshysh.task3.reader.impl.FigureReaderImpl;

public class FigureFactoryTest {

	@Test
	public void factoryRegularPyramidTest() throws FiguresException {
		RegularPyramid expected = new RegularPyramid(new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0), 5.0);
		RegularPyramid actual = (RegularPyramid) FigureFactory.newInstance("RegularPyramid:0.0,0.0,0.0;4;1.0;5.0");
		Assert.assertEquals(expected.equals(actual), true);
	}
	
	@Test
	public void factoryRegularPolygonTest() throws FiguresException {
		RegularPolygon expected = new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0);
		RegularPolygon actual = (RegularPolygon) FigureFactory.newInstance("RegularPolygon:0.0,0.0,0.0;4;1.0");
		Assert.assertEquals(expected.equals(actual), true);
	}
}
