package by.alekseyshysh.task3.reader.impl;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.reader.FigureReader;

public class ShapeReaderTest {

	private FigureReader figureReader = new FigureReaderImpl();

	@Test
	public void readAllCorrectLinesTest() throws FiguresException, URISyntaxException {
		URI uri = getClass().getResource("/data/data.txt").toURI();
		String absolutePath = new File(uri).getAbsolutePath();
		List<String> actualList = figureReader.readAllCorrectLines(absolutePath);
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("RegularPyramid:0.0,0.0,0.0;4;1.0;5.0");
		expectedList.add("RegularPyramid:11.1,-0.2,1.0;3;22.0;-3.0");
		expectedList.add("RegularPyramid:-1.0,2.0,-1.0;4;3.022;7.0");
		expectedList.add("RegularPyramid:4.0,-3.0,1.0;3;7.0;3.0");
		expectedList.add("RegularPolygon:8.0,2.0,1.0;3;7.0");
		Assert.assertEquals(actualList.equals(expectedList), true);
	}
}
