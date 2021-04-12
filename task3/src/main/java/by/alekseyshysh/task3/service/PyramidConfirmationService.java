package by.alekseyshysh.task3.service;

import by.alekseyshysh.task3.entity.Figure;
import by.alekseyshysh.task3.entity.RegularPyramid;

public interface PyramidConfirmationService {

	public boolean confirmShapeType(Figure figure, String figureName);
	
	public boolean confirmPyramidBaseOnCordinatePlane(RegularPyramid regularPyramid);
	
}
