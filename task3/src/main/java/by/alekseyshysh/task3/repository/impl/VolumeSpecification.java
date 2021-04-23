package by.alekseyshysh.task3.repository.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.entity.RegularPyramidParameter;
import by.alekseyshysh.task3.entity.Warehouse;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.repository.Specification;
import by.alekseyshysh.task3.service.RegularPyramidCalculationService;
import by.alekseyshysh.task3.service.impl.RegularPyramidCalculationServiceImpl;

public class VolumeSpecification implements Specification {

	private static Logger logger = LogManager.getRootLogger();
	 
	private double volumeMin;
	private double volumeMax;
	
	public VolumeSpecification(double volumeMin, double volumeMax) {
		this.volumeMin = volumeMin;
		this.volumeMax = volumeMax;
	}
	
	@Override
	public boolean specify(AbstractFigure figure) {
		String className = figure.getClass().getSimpleName();
		boolean result = false;
		switch (className) {
		case "RegularPyramid":
			RegularPyramid pyramid = (RegularPyramid) figure;
			RegularPyramidCalculationService pyramidCalculation = new RegularPyramidCalculationServiceImpl();
			double pyramidVolume = pyramidCalculation.calculateVolume(pyramid);
			result = volumeMin <= pyramidVolume & pyramidVolume <= volumeMax;
			break;
		default:
			logger.log(Level.ERROR, "No such action for figure: {}", className);
			break;
		}
		return result;
	}
	
	@Override
	public boolean specifyFromWarehouse(AbstractFigure figure) {
		Warehouse warehouse = Warehouse.getInstance();
		String className = figure.getClass().getSimpleName();
		long id = -1;
		boolean result = false;
		switch(className) {
			case "RegularPyramid":
				RegularPyramid pyramid = (RegularPyramid) figure;
				RegularPyramidParameter pyramidParameter;
				try {
					pyramid.getId();
					pyramidParameter = warehouse.getRegularPyramidParameter(id);
					double pyramidVolume = pyramidParameter.getVolume();
					result = volumeMin <= pyramidVolume & pyramidVolume <= volumeMax;
				} catch (FiguresException e) {
					logger.log(Level.ERROR, "Can not get figure by id: {}", id, e);
				}
				break;
			default:
				logger.log(Level.ERROR, "No such action for figure: {}", className);
				break;
		}
		return result;
	}
	
}
