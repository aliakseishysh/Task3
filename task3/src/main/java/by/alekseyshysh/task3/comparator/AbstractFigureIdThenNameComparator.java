package by.alekseyshysh.task3.comparator;

import java.util.Comparator;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class AbstractFigureIdThenNameComparator implements Comparator<AbstractFigure> {

	@Override
	public int compare(AbstractFigure figure1, AbstractFigure figure2) {
		AbstractFigureIdComparator idComparator = new AbstractFigureIdComparator();
		AbstractFigureNameComparator nameComparator = new AbstractFigureNameComparator();
		Comparator<AbstractFigure> idThenNameComparator = idComparator.thenComparing(nameComparator);
		return idThenNameComparator.compare(figure1, figure2);
	}

}
