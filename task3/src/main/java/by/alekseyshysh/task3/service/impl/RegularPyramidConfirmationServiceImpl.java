package by.alekseyshysh.task3.service.impl;

import by.alekseyshysh.task3.entity.Point;
import by.alekseyshysh.task3.entity.RegularPyramid;
import by.alekseyshysh.task3.service.RegularPyramidConfirmationService;

public class RegularPyramidConfirmationServiceImpl implements RegularPyramidConfirmationService {

	@Override
	public boolean confirmPyramidBaseOnCordinatePlane(RegularPyramid pyramid) {
		boolean result = false;
		if (pyramid != null) {
			Point point = pyramid.getBase().getCenter();
			if (point.getX() == 0 || point.getY() == 0 || point.getZ() == 0) {
				result = true;
			}
		}
		return result;
	}
}
