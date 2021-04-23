package by.alekseyshysh.task3.comparator;

import java.text.Collator;
import java.util.Comparator;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class AbstractFigureNameComparator implements Comparator<AbstractFigure>  {

	@Override
	public int compare(AbstractFigure figure1, AbstractFigure figure2) {
		Collator collator = Collator.getInstance();
		int result = collator.compare(figure1.getName(), figure2.getName());
		return result;
	}

	
	
}
