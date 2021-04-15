package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.BlogPost;

import java.util.List;

/**
 * An interface outlining the required functionality of the BlogPost resource
 *
 * @author Matthew Dodds W18020972
 */
public interface IBlogPostResource extends ICRUDResource<BlogPost, String> {
	/**
	 * Finds a BlogPost by the given ID
	 *
	 * @param id The ID to search with
	 * @return A matching BlogPost or null if there are no matches
	 */
	BlogPost find(String id);

	/**
	 * Returns the latest number of BlogPosts by a given quantity
	 *
	 * @param quantity The number of posts to return
	 * @return The requested number of posts
	 */
	List<BlogPost> getLatest(int quantity);
}
