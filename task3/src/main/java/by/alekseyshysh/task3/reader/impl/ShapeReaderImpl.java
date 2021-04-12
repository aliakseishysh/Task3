package by.alekseyshysh.task3.reader.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.reader.ShapeReader;
import by.alekseyshysh.task3.validator.FigureFileValidator;

/**
 * 
 * @author AlekseyShysh
 *
 */
public class ShapeReaderImpl implements ShapeReader {

	private static Logger rootLogger = LogManager.getLogger();
	
	private void checkFileExistence(Path path) throws FiguresException {
		if (!FigureFileValidator.validateFileExistence(path)) {
			throw new FiguresException("File by path: \'" + path.toString() +  "\'is not exist");
		}
	}

	public Path createPathFromRelative(String relativeFilePath) throws FiguresException {
		URI uri;
		try {
			uri = getClass().getResource(relativeFilePath).toURI();
		} catch (NullPointerException e) {
			throw new FiguresException("Name of the desired resource is null");
		} catch (URISyntaxException e) {
			throw new FiguresException(
					"URL is not formatted strictly according toRFC2396 and cannot be converted to a URI");
		}
		String absolutePath = new File(uri).getAbsolutePath();
		Path path;
		try {
			path = Paths.get(absolutePath);
		} catch (InvalidPathException ipe) {
			throw new FiguresException("path string cannot be converted to a Path");
		}
		checkFileExistence(path);
		return path;
	}

	public Path createPathFromAbsolute(String absoluteFilePath) throws FiguresException {
		Path path = Paths.get(absoluteFilePath);
		checkFileExistence(path);
		return path;
	}

	/**
	 * Method to read all lines in the file WITHOUT ANY VALIDATION
	 * 
	 * @param path to file
	 * @return String[] with all lines in the file
	 */
	public List<String> readAllLines(Path path) {
		var arrayList = new ArrayList<String>();
		try (Stream<String> stream = Files.lines(path)) {
			Iterator<String> iterator = stream.iterator();
			while (iterator.hasNext()) {
				String nextLine = iterator.next();
				arrayList.add(nextLine);
			}
		} catch (IOException e) {
			rootLogger.log(Level.ERROR, "Problem with file reading by path: \'{}\' occured", path);
		}
		return arrayList;
	}

	/**
	 * Method to read specific number of correct lines or LESS if end of lines
	 * Correct lines are selected by using regular expression in validation
	 * But values in file can be not only int, but ALL INTEGRAL VALUES
	 * So, while parsing we need to check for NumberFormatException
	 * Or use {@link #readAllLines(Path)} method.
	 * You can use methods of this class, or build Path by yourself 
	 * 
	 * @param numberOfCorrectLines number of correct lines to read from file
	 * @param path                 to file
	 * @return String[] with correct lines after validation
	 * @throws ArrayNoSuchFileException
	 */
	public List<String> readCorrectLines(int numberOfCorrectLines, Path path) {
		int currentNumberOfCorrectLines = 0;
		List<String> arrayList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			Iterator<String> iterator = stream.iterator();
			while (currentNumberOfCorrectLines < numberOfCorrectLines) {
				if (!iterator.hasNext()) {
					break;
				}
				String nextLine = iterator.next();
				if (FigureFileValidator.validateString(nextLine)) {
					arrayList.add(nextLine);
					currentNumberOfCorrectLines++;
				} else {
					rootLogger.log(Level.INFO, "Line: {} is not correct", nextLine);
				}
			}
		} catch (IOException e) {
			rootLogger.log(Level.ERROR, "Problem with file reading by path: \'{}\' occured", path);
		}
		return arrayList;
	}

	/**
	 * Method to read all correct lines in stream
	 * 
	 * @see #readCorrectLines()
	 * @throws ArrayNoSuchFileException
	 */
	public List<String> readAllCorrectLines(Path path) {
		List<String> arrayList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			Iterator<String> iterator = stream.iterator();
			while (iterator.hasNext()) {
				String nextLine = iterator.next();
				if (FigureFileValidator.validateString(nextLine)) {
					arrayList.add(nextLine);
				} else {
					rootLogger.log(Level.INFO, "Line: {} is not correct", nextLine);
				}
			}
		} catch (IOException e) {
			rootLogger.log(Level.ERROR, "Problem with file reading by path: \'{}\' occured", path);
		}
		return arrayList;
	}
}
