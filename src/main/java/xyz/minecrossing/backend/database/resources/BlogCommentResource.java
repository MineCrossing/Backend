package xyz.minecrossing.backend.database.resources;


import xyz.minecrossing.backend.database.builders.BlogCommentBuilder;
import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.ParamSpecification;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogCommentResource;
import xyz.minecrossing.backend.database.models.BlogComment;

import java.util.List;

public class BlogCommentResource extends MineCrossingResource<BlogComment, String> implements IBlogCommentResource {

	public BlogCommentResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_comments");
	}

	@Override
	protected ModelBuilder<BlogComment> modelBuilder() {
		return new BlogCommentBuilder();
	}

	@Override
	public List<BlogComment> findByUserID(int userID) {
		return findBy(new ParamSpecification<>(BlogComment.USER_ID_COL, userID));
	}

	@Override
	public List<BlogComment> findByBlogPostID(String blogPostID) {
		return findBy(new ParamSpecification<>(BlogComment.BLOG_POST_ID_COL, blogPostID));
	}

	@Override
	public BlogComment find(String id) {
		return find(BlogComment.BLOG_COMMENT_ID_COL, id);
	}
}
