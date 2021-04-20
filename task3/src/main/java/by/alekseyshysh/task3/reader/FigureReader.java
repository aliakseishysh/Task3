package by.alekseyshysh.task3.reader;

import java.nio.file.Path;
import java.util.List;

import by.alekseyshysh.task3.exception.FiguresException;

public interface FigureReader {

	public Path createPathFromRelative(String relativeFilePath) throws FiguresException;

	public Path createPathFromAbsolute(String absoluteFilePath) throws FiguresException;

	public List<String> readAllLines(Path path);

	public List<String> readCorrectLines(int numberOfCorrectLines, Path path);

	public List<String> readAllCorrectLines(Path path);

}
