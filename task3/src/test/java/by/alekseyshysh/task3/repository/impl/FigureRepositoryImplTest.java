package by.alekseyshysh.task3.repository.impl;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.Point;
import by.alekseyshysh.task3.entity.RegularPolygon;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.repository.FiguresRepository;

public class FigureRepositoryImplTest {

	private AbstractFigure polygon1;
	private AbstractFigure pyramid1;
	private AbstractFigure polygon2;
	private AbstractFigure pyramid2;
	private FiguresRepository repository;

	@BeforeSuite
	public void figuresCreationAndSetup() {
		repository = FiguresRepositoryImpl.getInstance();
		polygon1 = new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0);
		polygon1.setId(10);
		polygon1.setName("RegularPolygon");
		pyramid1 = new RegularPyramid((RegularPolygon) polygon1, 5.0);
		pyramid1.setId(1);
		pyramid1.setName("RegularPyramid");
		polygon2 = new RegularPolygon(new Point(0.0, 0.0, 0.0), 4, 1.0);
		polygon2.setId(1);
		polygon2.setName("RegularPolygon");
		pyramid2 = new RegularPyramid((RegularPolygon) polygon2, 5.0);
		pyramid2.setId(5);
		pyramid2.setName("RegularPyramid");
	}

	@BeforeTest
	public void repositorySetup() throws FiguresException {
		repository.clear();
		repository.add(polygon1);
		repository.add(pyramid1);
		repository.add(polygon2);
		repository.add(pyramid2);
	}

	@Test
	public void correctInitTest() {
		int expected = repository.size();
		int actual = 4;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void queryStreamIdSpecificationTest() {
		IdSpecification specification = new IdSpecification(1, 1);
		String expected = "[1, 1]";
		String actual = repository.queryStream(specification).stream().map(AbstractFigure::getId)
				.collect(Collectors.toList()).toString();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void queryStreamNameSpecificationTest() {
		NameSpecification specification = new NameSpecification("RegularPyramid");
		String expected = "[RegularPyramid, RegularPyramid]";
		String actual = repository.queryStream(specification).stream().map(AbstractFigure::getName)
				.collect(Collectors.toList()).toString();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void queryStreamVolumeSpecificationTest() {
		VolumeSpecification specification = new VolumeSpecification(1, 100);
		String expected = "[RegularPyramid, RegularPyramid]";
		String actual = repository.queryStream(specification).stream().map(AbstractFigure::getName)
				.collect(Collectors.toList()).toString();
		Assert.assertEquals(actual, expected);
		
	}
	

	@Test
	public void queryStreamIdSpecificationPredicateTest() {
		String expected = "[10, 5]";
		String actual = repository.queryStream((Predicate<AbstractFigure>) (figure -> figure.getId() > 1)).stream()
				.map(AbstractFigure::getId).collect(Collectors.toList()).toString();
		Assert.assertEquals(actual, expected);
	}

}
