package by.alekseyshysh.task3.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.reader.FigureReader;
import by.alekseyshysh.task3.validator.FigureFileValidator;

/**
 * 
 * @author AlekseyShysh
 *
 */
public class FigureReaderImpl implements FigureReader {

	private static Logger rootLogger = LogManager.getLogger();
	
	/**
	 * Method to read all correct lines with stream
	 * @throws FiguresException 
	 * 
	 * @see #readCorrectLines()
	 */
	public List<String> readAllCorrectLines(String absolutePath) throws FiguresException {
		Path path = Paths.get(absolutePath);
		List<String> arrayList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			arrayList = stream.filter(FigureFileValidator::validateString).collect(Collectors.toList());
		} catch (IOException e) {
			rootLogger.log(Level.ERROR, "Problem with file reading by path: \'{}\' occured", path);
			throw new FiguresException("Problem with file reading by path :" + path + " occured");
		}
		return arrayList;
	}
	
	/**
	 * @param numberOfCorrectLines number of correct lines to read from file
	 * @param path to file
	 * @return List<String> with correct lines after validation
	 * @throws FiguresException 
	 */
	public List<String> readCorrectLines(int numberOfCorrectLines, String absolutePath) throws FiguresException {
		Path path = Paths.get(absolutePath);
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
			throw new FiguresException("Problem with file reading by path :" + path + " occured");
		}
		return arrayList;
	}

	/**
	 * Method to read all lines in the file WITHOUT ANY VALIDATION
	 * 
	 * @param path to file
	 * @return List<String> with all lines in the file
	 * @throws FiguresException 
	 */
	public List<String> readAllLines(String absolutePath) throws FiguresException {
		Path path = Paths.get(absolutePath);
		List<String> arrayList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			arrayList = stream.collect(Collectors.toList());
		} catch (IOException e) {
			rootLogger.log(Level.ERROR, "Problem with file reading by path: \'{}\' occured", path);
			throw new FiguresException("Problem with file reading by path :" + path + " occured");
		}
		return arrayList;
	}

	


}
