package by.alekseyshysh.task3.service;

import by.alekseyshysh.task3.entity.RegularPolygon;

public interface RegularPolygonCalculationService {

	double calculatePerimeter(RegularPolygon polygon);
	
	double calculateArea(RegularPolygon polygon);

	double calulateInscribedCircleRadius(RegularPolygon polygon); 
	
}
