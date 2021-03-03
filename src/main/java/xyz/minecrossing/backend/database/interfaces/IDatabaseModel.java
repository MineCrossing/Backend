package xyz.minecrossing.backend.database.interfaces;

/**
 * A database model interface which provides useful contextual information
 *
 * @param <K> The key type of the entity
 */
public interface IDatabaseModel<K> {
	K getKey();
}
