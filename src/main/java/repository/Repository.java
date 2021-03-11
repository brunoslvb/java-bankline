package repository;

import java.util.List;

public interface Repository <E> {
	public void save(E e);
	public void update(E e);
	public void delete(Object id);
	public List<E> list();
	public E find(Object id);
}
