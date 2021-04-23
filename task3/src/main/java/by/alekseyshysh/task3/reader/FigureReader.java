package by.alekseyshysh.task3.reader;

import java.util.List;

public interface FigureReader {

	public List<String> readAllCorrectLines(String absolutePath);
	
	public List<String> readCorrectLines(int numberOfCorrectLines, String path);
	
	public List<String> readAllLines(String path);

}
