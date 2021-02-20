package xyz.minecrossing.backend.database.interfaces;

public interface ICRUDResource<T> {
	boolean Add(T entity);
	<K> T Find(K key);
}
