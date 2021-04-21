package by.alekseyshysh.task3.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.repository.Specification;

public class FiguresRepositoryImpl {

	private List<AbstractFigure> figures;

	public boolean add(AbstractFigure figure) {
		return figures.add(figure);
	}

	public boolean addAll(Collection<? extends AbstractFigure> collection) {
		return figures.addAll(collection);
	}

	public boolean remove(AbstractFigure figure) {
		return figures.remove(figure);
	}

	public boolean removeAll(Collection<?> collection) {
		return figures.removeAll(collection);
	}

	public AbstractFigure get(int index) {
		return figures.get(index);
	}

	public AbstractFigure set(int index, AbstractFigure figure) {
		return figures.set(index, figure);
	}

	public List<AbstractFigure> query(Specification specification) {
		List<AbstractFigure> list = new ArrayList<>();
		for (AbstractFigure figure : figures) {
			if (specification.specify(figure)) {
				list.add(figure);
			}
		}
		return list;
	}

	public List<AbstractFigure> query(Predicate<AbstractFigure> specification) {
		List<AbstractFigure> list = new ArrayList<>();
		for (AbstractFigure figure : figures) {
			if (specification.test(figure)) {
				list.add(figure);
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

	public List<AbstractFigure> sort() {
		Comparator<AbstractFigure> compareById = Comparator.comparing(AbstractFigure::getId);
		Comparator<AbstractFigure> compareByName = Comparator.comparing(AbstractFigure::getName);
		Comparator<AbstractFigure> compareByIdThenName = compareById.thenComparing(compareByName);
		List<AbstractFigure> result = figures.stream().sorted(compareByIdThenName).collect(Collectors.toList());
		return result;
	}
}
