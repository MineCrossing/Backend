package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.BlogComment;

import java.util.List;

public interface IBlogCommentResource extends ICRUDResource<BlogComment, String> {
	BlogComment find(String id);
	List<BlogComment> findByUserID(int userID);
	List<BlogComment> findByBlogPostID(String blogPostID);
}
