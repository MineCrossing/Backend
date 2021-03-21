package xyz.minecrossing.backend.database.interfaces;


import xyz.minecrossing.backend.database.helpers.ParamSpecification;

import java.util.List;

/**
 * An interface for a simple CRUD database resource
 *
 * @param <T> The entity type
 * @param <K> The entity's primary key type
 */
public interface ICRUDResource<T extends IDatabaseModel<K>, K> {
	boolean add(T entity);

	boolean update(T entity);

	T find(String keyCol, K key);

	List<T> findBy(ParamSpecification<?> spec);

	List<T> findAll();

	boolean delete(T object);

	boolean addOrUpdate(T entity);

}
