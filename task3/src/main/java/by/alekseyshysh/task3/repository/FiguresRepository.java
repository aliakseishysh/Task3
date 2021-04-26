package by.alekseyshysh.task3.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.exception.FiguresException;

public interface FiguresRepository {

	int size();
	
	boolean isEmpty();
	
	boolean contains(AbstractFigure figure);
	
	boolean add(AbstractFigure figure) throws FiguresException;
	
	boolean addAll(Collection<? extends AbstractFigure> collection) throws FiguresException;
	
	boolean remove(AbstractFigure figure);
	
	boolean removeAll(Collection<?> collection);
	
	void clear();
	
	AbstractFigure get(int index) throws FiguresException;
	
	AbstractFigure set(int index, AbstractFigure figure) throws FiguresException;
	
	List<AbstractFigure> query(Specification specification) throws FiguresException;
	
	List<AbstractFigure> query(Predicate<AbstractFigure> specification) throws FiguresException;
	
	List<AbstractFigure> queryStream(Specification specification);
	
	List<AbstractFigure> queryStream(Predicate<AbstractFigure> specification);
	
	List<AbstractFigure> sort(Comparator<AbstractFigure> comparator);
	
}
