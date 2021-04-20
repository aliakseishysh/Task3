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
		for (AbstractFigure figure: figures) {
			if (specification.specify(figure)) {
				list.add(figure);
			}
		}
		return list;
	}
	
	public List<AbstractFigure> query(Predicate<AbstractFigure> specification) {
		List<AbstractFigure> list = new ArrayList<>();
		for (AbstractFigure figure: figures) {
			if (specification.test(figure)) {
				list.add(figure);
			}
		}
		return list;
	}

	public List<AbstractFigure> queryStream(Specification specification) {
		List<AbstractFigure> list = figures.stream().filter(figure -> specification.specify(figure)).collect(Collectors.toList());
		return list;
	}
	
	public List<AbstractFigure> queryStream(Predicate<AbstractFigure> specification) {
		List<AbstractFigure> list = figures.stream().filter(figure -> specification.test(figure)).collect(Collectors.toList());
		return list;
	}
	
	public List<AbstractFigure> sort() {
		Comparator<AbstractFigure> comparator = new Comparator<>() {

			@Override
			public int compare(AbstractFigure figure1, AbstractFigure figure2) {
				if (figure1.getId() > figure2.getId()) {
					return 1;
				}
				if (figure1.getId() == figure2.getId()) {
					if (figure1.getName().compareTo(figure2.getName()) > 0) {
						return 1;
					}
				}
				return -1;
			}
			
		};
		List<AbstractFigure> list = new ArrayList<>(figures);
		Collections.sort(list, comparator);
		return list;
	}
	
	public List<AbstractFigure> sortStream() {
		List<AbstractFigure> list = new ArrayList<>(figures).stream().sorted(null).collect(Collectors.toList());
		return list;
	}

}
