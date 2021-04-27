package by.alekseyshysh.task3.comparator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.Point;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.exception.FiguresException;

public class AbstractFigureComparatorTest {

	private AbstractFigure polygon1;
	private AbstractFigure pyramid1;
	private AbstractFigure polygon2;
	private AbstractFigure pyramid2;
	
	@BeforeClass
	public void figuresCreationAndSetup() {
		polygon1 = new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0);
		polygon1.setId(10);
		polygon1.setName("Pol");
		pyramid1 = new RegularPyramid((RegularPolygon) polygon1, 5.0);
		pyramid1.setId(1);
		pyramid1.setName("P2");
		polygon2 = new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0);
		polygon2.setId(1);
		polygon2.setName("P1");
		pyramid2 = new RegularPyramid((RegularPolygon) polygon2, 5.0);
		pyramid2.setId(5);
		pyramid2.setName("Pyr");
	}
	
	@Test
	public void idTest() throws FiguresException {
		String expected = "[1, 1, 5, 10]";
		AbstractFigureIdComparator comparator = new AbstractFigureIdComparator();
		List<AbstractFigure> result = Stream.of(polygon1, pyramid1, pyramid2, polygon2).sorted(comparator::compare).collect(Collectors.toList());
		String actual = result.stream()
				.map(AbstractFigure::getId)
				.collect(Collectors.toList())
				.toString();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void nameTest() {
		String expected = "[P1, P2, Pol, Pyr]";
		AbstractFigureNameComparator comparator = new AbstractFigureNameComparator();
		List<AbstractFigure> result = Stream.of(polygon1, pyramid1, pyramid2, polygon2).sorted(comparator::compare).collect(Collectors.toList());
		String actual = result.stream()
				.map(AbstractFigure::getName)
				.collect(Collectors.toList())
				.toString();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void idThenNameTest() {
		String expected = "[P1, P2, Pyr, Pol]";
		AbstractFigureIdThenNameComparator comparator = new AbstractFigureIdThenNameComparator();
		List<AbstractFigure> result = Stream.of(polygon1, pyramid1, pyramid2, polygon2)
				.sorted(comparator::compare)
				.collect(Collectors.toList());
		String actual = result.stream()
				.map(AbstractFigure::getName)
				.collect(Collectors.toList())
				.toString();
		Assert.assertEquals(actual, expected);
	}

}
