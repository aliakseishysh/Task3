package by.alekseyshysh.task3.entity;

import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.parser.impl.FigureParameter;

public interface AbstractFigureFactory {

	public abstract AbstractFigure newInstance(FigureParameter figureParameter) throws FiguresException;
	
	public abstract AbstractFigure newInstance(AbstractFigure abstractFigure) throws FiguresException;
	
}
