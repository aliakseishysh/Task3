package by.alekseyshysh.task3.util;

public class IdGenerator {

	private static long counter;
	
	private IdGenerator() {
	}
	
	public static long generateNextId() {
		return counter++;
	}
	
}
