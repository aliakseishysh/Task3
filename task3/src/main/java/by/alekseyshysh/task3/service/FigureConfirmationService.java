package by.alekseyshysh.task3.service;

import by.alekseyshysh.task3.entity.AbstractFigure;

public interface FigureConfirmationService {

	public boolean confirmShapeType(AbstractFigure abstractFigure, String figureName);
	
}
