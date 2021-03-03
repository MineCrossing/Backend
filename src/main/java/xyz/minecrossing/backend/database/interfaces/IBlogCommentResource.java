package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.BlogCommentDTO;

import java.util.List;

public interface IBlogCommentResource extends ICRUDResource<BlogCommentDTO, String> {
	BlogCommentDTO find(String id);
	List<BlogCommentDTO> findByUserID(int userID);
	List<BlogCommentDTO> findByBlogPostID(String blogPostID);
}
