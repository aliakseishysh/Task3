package by.alekseyshysh.task3.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import by.alekseyshysh.task3.entity.Figure;

public class FiguresRepository {

	private List<Figure> figures;

	public boolean add(Figure figure) {
		return figures.add(figure);
	}

	public boolean addAll(Collection<? extends Figure> collection) {
		return figures.addAll(collection);
	}

	public boolean remove(Figure figure) {
		return figures.remove(figure);
	}

	public boolean removeAll(Collection<?> collection) {
		return figures.removeAll(collection);
	}

	public Figure get(int index) {
		return figures.get(index);
	}

	public Figure set(int index, Figure figure) {
		return figures.set(index, figure);
	}

	public List<Figure> queryStream(Specification specification) {
		// TODO replace collect with something new
		List<Figure> list = figures.stream().filter(figure -> specification.specify(figure)).collect(Collectors.toList());
		return list;
	}
	
	public List<Figure> queryStream(Predicate<Figure> specification) {
		List<Figure> list = figures.stream().filter(figure -> specification.test(figure)).collect(Collectors.toList());
		return list;
	}
	
	// TODO add comparator
	// TODO sort by: id, name, and others
	public List<Figure> sort() {
		List<Figure> list = new ArrayList<>(figures).stream().sorted(null).collect(Collectors.toList());
		return list;
	}

}
