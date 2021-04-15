package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.controller.api.viewmodels.BlogCommentVM;
import xyz.minecrossing.backend.database.models.BlogComment;

import java.util.List;

/**
 * An interface outlining the required functionality of the BlogComment resource
 *
 * @author Matthew Dodds W18020972
 */
public interface IBlogCommentResource extends ICRUDResource<BlogComment, String> {
	/**
	 * Finds a blog comment by ID
	 *
	 * @param id The ID to find the comment by
	 * @return The BlogComment if a match is found, null if not
	 */
	BlogComment find(String id);

	/**
	 * Finds all BlogComments by a given user ID
	 *
	 * @param userID The user ID to find the comments by
	 * @return A List of BlogComments for the given user
	 */
	List<BlogComment> findByUserID(int userID);

	/**
	 * Finds all BlogComments by a given BlogPost ID
	 *
	 * @param blogPostID The BlogPost ID to find the comments by
	 * @return A List of BlogComments for the given post
	 */
	List<BlogComment> findByBlogPostID(String blogPostID);

	/**
	 * Finds all BlogComments by a given BlogPost ID, including the username of the user who created the comment
	 *
	 * @param blogPostID The BlogPost ID to find the comments by
	 * @return A List of BlogComments for the given post
	 */
	List<BlogCommentVM> findByBlogPostIDWithUsers(String blogPostID);
}
