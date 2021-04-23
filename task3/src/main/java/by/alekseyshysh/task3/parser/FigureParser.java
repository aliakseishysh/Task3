package by.alekseyshysh.task3.parser;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.impl.FigureParameter;

public interface FigureParser {

	FigureParameter createParameters(String figure) throws FiguresException;
	
}
