package by.alekseyshysh.task3.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import by.alekseyshysh.task3.entity.AbstractFigure;
import by.alekseyshysh.task3.repository.FiguresRepository;
import by.alekseyshysh.task3.specification.Specification;

public class FiguresRepositoryImpl implements FiguresRepository {

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

	public boolean add(AbstractFigure figure) {
		return figures.add(figure.clone());
	}

	public boolean addAll(Collection<? extends AbstractFigure> collection) {
		List<AbstractFigure> newList = new ArrayList<>();
		boolean result = true;
		for (AbstractFigure figure : collection) {
			newList.add(figure.clone());
		}
		figures.addAll(newList);
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

	public AbstractFigure get(int index) {
		return figures.get(index).clone();
	}

	public AbstractFigure set(int index, AbstractFigure figure) {
		return figures.set(index, figure.clone());
	}

	public List<AbstractFigure> query(Specification specification) {
		List<AbstractFigure> list = new ArrayList<>();
		for (AbstractFigure figure : figures) {
			if (specification.specify(figure)) {
				list.add(figure.clone());
			}
		}
		return list;
	}

	public List<AbstractFigure> query(Predicate<AbstractFigure> specification) {
		List<AbstractFigure> list = new ArrayList<>();
		for (AbstractFigure figure : figures) {
			if (specification.test(figure)) {
				list.add(figure.clone());
			}
		}
		return list;
	}

	public List<AbstractFigure> queryStream(Specification specification) {
		List<AbstractFigure> list = figures.stream()
				.filter(specification::specify)
				.map(AbstractFigure::clone)
				.collect(Collectors.toList());
		return list;
	}

	public List<AbstractFigure> queryStream(Predicate<AbstractFigure> specification) {
		List<AbstractFigure> list = figures.stream()
				.filter(specification::test)
				.map(AbstractFigure::clone)
				.collect(Collectors.toList());
		return list;
	}

	public List<AbstractFigure> sort(Comparator<AbstractFigure> comparator) {
		List<AbstractFigure> result = figures.stream()
				.sorted(comparator)
				.map(AbstractFigure::clone)
				.collect(Collectors.toList());
		return result;
	}
}
