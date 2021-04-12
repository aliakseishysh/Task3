package by.alekseyshysh.task3.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import by.alekseyshysh.task3.entity.AbstractFigure;

public class FiguresRepository {

	private List<AbstractFigure> abstractFigures;

	public boolean add(AbstractFigure abstractFigure) {
		return abstractFigures.add(abstractFigure);
	}

	public boolean addAll(Collection<? extends AbstractFigure> collection) {
		return abstractFigures.addAll(collection);
	}

	public boolean remove(AbstractFigure abstractFigure) {
		return abstractFigures.remove(abstractFigure);
	}

	public boolean removeAll(Collection<?> collection) {
		return abstractFigures.removeAll(collection);
	}

	public AbstractFigure get(int index) {
		return abstractFigures.get(index);
	}

	public AbstractFigure set(int index, AbstractFigure abstractFigure) {
		return abstractFigures.set(index, abstractFigure);
	}

	public List<AbstractFigure> queryStream(Specification specification) {
		// TODO replace collect with something new
		List<AbstractFigure> list = abstractFigures.stream().filter(figure -> specification.specify(figure)).collect(Collectors.toList());
		return list;
	}
	
	public List<AbstractFigure> queryStream(Predicate<AbstractFigure> specification) {
		List<AbstractFigure> list = abstractFigures.stream().filter(figure -> specification.test(figure)).collect(Collectors.toList());
		return list;
	}
	
	// TODO add comparator
	// TODO sort by: id, name, and others
	public List<AbstractFigure> sort() {
		List<AbstractFigure> list = new ArrayList<>(abstractFigures).stream().sorted(null).collect(Collectors.toList());
		return list;
	}

}
