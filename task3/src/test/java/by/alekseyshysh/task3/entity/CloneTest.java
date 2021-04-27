package by.alekseyshysh.task3.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.alekseyshysh.task3.observer.impl.RegularPolygonObserverImpl;
import by.alekseyshysh.task3.observer.impl.RegularPyramidObserverImpl;

public class CloneTest {

	@Test
	public void RegularPolygonTest() {
		RegularPolygon original = new RegularPolygon(new Point(1,2,3), 1, 2);
		original.setId(1);
		original.setName("RegularPolygon");
		original.attach(new RegularPolygonObserverImpl());
		original.attach(new RegularPolygonObserverImpl());
		RegularPolygon copy = original.clone();
		boolean expected = true;
		boolean actual = original.equals(copy)
				&& original.getCenter() != copy.getCenter();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void RegularPyramidTest() {
		RegularPolygon polygon = new RegularPolygon(new Point(1,2,3), 1, 2);
		RegularPyramid original = new RegularPyramid(polygon, 2);
		original.setId(1);
		original.setName("RegularPyramid");
		original.attach(new RegularPyramidObserverImpl());
		original.attach(new RegularPyramidObserverImpl());
		RegularPyramid copy = original.clone();
		boolean expected = true;
		boolean actual = original.equals(copy)
				&& original.getBase() != copy.getBase()
				&& original.getBase().getCenter() != copy.getBase().getCenter();
		System.out.println(original + "\n" + copy);
		Assert.assertEquals(actual, expected);
	}
	
	
	
}
