package by.alekseyshysh.task3.comparator;

import java.util.Comparator;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class AbstractFigureNameComparator implements Comparator<AbstractFigure>  {

	@Override
	public int compare(AbstractFigure figure1, AbstractFigure figure2) {
		return figure1.getName().compareTo(figure2.getName());
	}

	
	
}
