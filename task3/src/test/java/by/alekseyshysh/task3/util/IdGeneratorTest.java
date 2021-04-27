package by.alekseyshysh.task3.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IdGeneratorTest {

	@Test
	public void generateNextIdTest() {
		long actual = IdGenerator.generateNextId();
		actual = IdGenerator.generateNextId();
		long expected = 1L;
		Assert.assertEquals(expected, actual);
	}
	
}
