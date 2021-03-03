package xyz.minecrossing.backend.database.resources;


import xyz.minecrossing.backend.database.builders.BlogCommentDTOBuilder;
import xyz.minecrossing.backend.database.builders.DTOBuilder;
import xyz.minecrossing.backend.database.helpers.ParamSpecification;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogCommentResource;
import xyz.minecrossing.backend.database.models.BlogCommentDTO;

import java.util.List;

public class BlogCommentResource extends MineCrossingResource<BlogCommentDTO, String> implements IBlogCommentResource {

	public BlogCommentResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_comments");
	}

	@Override
	protected DTOBuilder<BlogCommentDTO> modelBuilder() {
		return new BlogCommentDTOBuilder();
	}

	@Override
	public List<BlogCommentDTO> findByUserID(int userID) {
		return findBy(new ParamSpecification<>(BlogCommentDTO.USER_ID_COL, userID));
	}

	@Override
	public List<BlogCommentDTO> findByBlogPostID(String blogPostID) {
		return findBy(new ParamSpecification<>(BlogCommentDTO.BLOG_POST_ID_COL, blogPostID));
	}

	@Override
	public BlogCommentDTO find(String id) {
		return find(BlogCommentDTO.BLOG_COMMENT_ID_COL, id);
	}
}
