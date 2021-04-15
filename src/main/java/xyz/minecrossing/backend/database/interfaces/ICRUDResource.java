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
	/**
	 * Provides CREATE functionality
	 *
	 * @param entity The entity to create
	 * @return True if successful, false otherwise
	 */
	boolean add(T entity);

	/**
	 * Provides UPDATE functionality
	 *
	 * @param entity The entity to update
	 * @return True if successful, false otherwise
	 */
	boolean update(T entity);

	/**
	 * Provides READ functionality
	 *
	 * @param keyCol The name of the primary key column
	 * @param key The value to search by
	 * @return True if successful, false otherwise
	 */
	T find(String keyCol, K key);

	/**
	 * Finds an item by a given param specification
	 *
	 * @param spec The column name/value pair to search by
	 * @return A list of matching rows
	 */
	List<T> findBy(ParamSpecification<?> spec);

	/**
	 * Provides SELECT * functionality and finds all items in the collection
	 * @return A list of all items
	 */
	List<T> findAll();

	/**
	 * Provides DELETE functionality
	 *
	 * @param object the object to remove
	 * @return True if successful, false otherwise
	 */
	boolean delete(T object);

	/**
	 * Creates a new row if one does not already exist. Updates a row if it does already exist.
	 *
	 * @param entity The entity to add or update
	 * @return True if successful, false otherwise
	 */
	boolean addOrUpdate(T entity);

}
