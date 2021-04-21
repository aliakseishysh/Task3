package by.alekseyshysh.task3.comparator;

import java.util.Comparator;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class AbstractFigureIdComparator implements Comparator<AbstractFigure> {

	@Override
	public int compare(AbstractFigure figure1, AbstractFigure figure2) {
		if (figure1.getId() > figure2.getId()) {
			return 1;
		} else if (figure1.getId() < figure2.getId()) {
			return -1;
		}
		return 0;
	}

}
