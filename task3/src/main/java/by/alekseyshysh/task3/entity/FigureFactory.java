package by.alekseyshysh.task3.entity;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.impl.FigureParameter;

public interface FigureFactory {

	public abstract AbstractFigure newInstance(FigureParameter figureParameter) throws FiguresException;
	
}
