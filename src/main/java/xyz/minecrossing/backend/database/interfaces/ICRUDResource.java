package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.coreutilities.dbmodels.IDatabaseModel;

/**
 * An interface for a simple CRUD database resource
 *
 * @param <T> The entity type
 * @param <K> The entity's primary key type
 */
public interface ICRUDResource<T extends IDatabaseModel<K>, K> {
	boolean add(T entity);

	boolean update(T entity);

	T find(K key);

	boolean delete(K key);

	default boolean addOrUpdate(T entity) {
		return (find(entity.getKey()) == null) ? add(entity) : update(entity);
	}

}
