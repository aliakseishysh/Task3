package by.alekseyshysh.task3.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.exception.FiguresException;
import by.alekseyshysh.task3.repository.FiguresRepository;
import by.alekseyshysh.task3.repository.Specification;

public class FiguresRepositoryImpl implements FiguresRepository {
	
	private static Logger logger = LogManager.getRootLogger();
	private static final FiguresRepository instance = new FiguresRepositoryImpl();
 	private final List<AbstractFigure> figures = new ArrayList<>();
 	
 	private FiguresRepositoryImpl() {
 	}
 	
 	public static FiguresRepository getInstance() {
 		return instance;
 	}

 	public int size() {
 		return figures.size();
 	}
 	
 	public boolean isEmpty() {
 		return figures.isEmpty();
 	}
 	
 	public boolean contains(AbstractFigure figure) {
 		return figures.contains(figure);
 	}

	public boolean add(AbstractFigure figure) throws FiguresException {
		return figures.add(figure.copy());
	}

	public boolean addAll(Collection<? extends AbstractFigure> collection) throws FiguresException {
		List<AbstractFigure> newList = new ArrayList<>();
		boolean result = true;
		try {
			for (AbstractFigure figure: collection) {
				newList.add(figure.copy());
			}
			figures.addAll(newList);
		} catch (FiguresException e) {
			result = false;
		}
		return result;
	}

	public boolean remove(AbstractFigure figure) {
		return figures.remove(figure);
	}

	public boolean removeAll(Collection<?> collection) {
		return figures.removeAll(collection);
	}
	
	public void clear() {
		figures.clear();
	}

	public AbstractFigure get(int index) throws FiguresException {
		return figures.get(index).copy();
	}

	public AbstractFigure set(int index, AbstractFigure figure) throws FiguresException {
		return figures.set(index, figure.copy());
	}

	public List<AbstractFigure> query(Specification specification) throws FiguresException {
		List<AbstractFigure> list = new ArrayList<>();
		for (AbstractFigure figure : figures) {
			if (specification.specify(figure)) {
				list.add(figure.copy());
			}
		}
		return list;
	}

	public List<AbstractFigure> query(Predicate<AbstractFigure> specification) throws FiguresException {
		List<AbstractFigure> list = new ArrayList<>();
		for (AbstractFigure figure : figures) {
			if (specification.test(figure)) {
				list.add(figure.copy());
			}
		}
		return list;
	}

	public List<AbstractFigure> queryStream(Specification specification) {
		List<AbstractFigure> list = figures.stream().filter(specification::specify).collect(Collectors.toList());
		return list;
	}

	public List<AbstractFigure> queryStream(Predicate<AbstractFigure> specification) {
		List<AbstractFigure> list = figures.stream().filter(specification::test).collect(Collectors.toList());
		return list;
	}

	public List<AbstractFigure> sort(Comparator<AbstractFigure> comparator) {
		List<AbstractFigure> result = figures.stream().sorted(comparator).collect(Collectors.toList());
		return result;
	}
}
