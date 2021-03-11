package repository;

import java.util.List;

public interface Repository <E> {
	public void save(E e);
	public void update(E e);
	public void delete(E e);
	public List<E> list();
	public E find(String login);
}
