package by.alekseyshysh.task3.comparator;

import java.util.Comparator;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class AbstractFigureNameComparator implements Comparator<AbstractFigure>  {

	@Override
	public int compare(AbstractFigure figure1, AbstractFigure figure2) {
		String name1 = figure1.getName();
		String name2 = figure2.getName();
		int result = name1.compareTo(name2);
		return result;
	}

	
	
}
