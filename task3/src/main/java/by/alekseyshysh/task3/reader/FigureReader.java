package by.alekseyshysh.task3.reader;

import java.util.List;

import by.alekseyshysh.task3.exception.FiguresException;

public interface FigureReader {

	public List<String> readAllCorrectLines(String absolutePath) throws FiguresException;
	
	public List<String> readCorrectLines(int numberOfCorrectLines, String path) throws FiguresException;
	
	public List<String> readAllLines(String path) throws FiguresException;

}
