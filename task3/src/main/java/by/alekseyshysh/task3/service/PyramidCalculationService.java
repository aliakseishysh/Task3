package by.alekseyshysh.task3.service;

import by.alekseyshysh.task3.entity.RegularPyramid;

public interface PyramidCalculationService {

	public double calculateSurfaceArea(RegularPyramid regularPyramid);
	
	public double calculateVolume(RegularPyramid regularPyramid);
	
	public double calculateDissectionVolumesRatio(RegularPyramid regularPyramid, double dissectionHeight);
	
}
