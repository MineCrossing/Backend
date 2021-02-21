package xyz.minecrossing.backend.database.interfaces;

/**
 * An interface for a simple CRUD database resource
 *
 * @param <T> The entity type
 * @param <K> The entity's primary key type
 */
public interface ICRUDResource<T, K> {
	boolean Add(T entity);
	T Find(K key);
}
