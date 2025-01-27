package xyz.minecrossing.backend.database.resources;


import xyz.minecrossing.backend.controller.api.viewmodels.BlogCommentVM;
import xyz.minecrossing.backend.controller.api.viewmodels.builders.BlogCommentVMBuilder;
import xyz.minecrossing.backend.database.builders.BlogCommentBuilder;
import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.EntityToPreparedStatementMapper;
import xyz.minecrossing.backend.database.helpers.ParamSpecification;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogCommentResource;
import xyz.minecrossing.backend.database.models.BlogComment;
import xyz.minecrossing.backend.database.models.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of IBlogCommentResource
 *
 * @author Matthew Dodds W18020972
 */
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

	/**
	 * Finds a blog comment by ID
	 *
	 * @param id The ID to find the comment by
	 * @return The BlogComment if a match is found, null if not
	 */
	@Override
	public BlogComment find(String id) {
		return find(BlogComment.BLOG_COMMENT_ID_COL, id);
	}

	/**
	 * Finds all BlogComments by a given user ID
	 *
	 * @param userID The user ID to find the comments by
	 * @return A List of BlogComments for the given user
	 */
	@Override
	public List<BlogComment> findByUserID(int userID) {
		return findBy(new ParamSpecification<>(BlogComment.USER_ID_COL, userID));
	}

	/**
	 * Finds all BlogComments by a given BlogPost ID
	 *
	 * @param blogPostID The BlogPost ID to find the comments by
	 * @return A List of BlogComments for the given post
	 */
	@Override
	public List<BlogComment> findByBlogPostID(String blogPostID) {
		return findBy(new ParamSpecification<>(BlogComment.BLOG_POST_ID_COL, blogPostID));
	}

	/**
	 * Finds all BlogComments by a given BlogPost ID, including the username of the user who created the comment
	 *
	 * @param blogPostID The BlogPost ID to find the comments by
	 * @return A List of BlogComments for the given post
	 */
	@Override
	public List<BlogCommentVM> findByBlogPostIDWithUsers(String blogPostID) {
		var foundEntities = new ArrayList<BlogCommentVM>();

		var query = "SELECT * FROM minecrossing.blog_comments\n" +
				"INNER JOIN `store-minecrossing`.users ON `store-minecrossing`.users.id = minecrossing.blog_comments.user_id\n" +
				"WHERE minecrossing.blog_comments.blog_post_id = :" + BlogComment.BLOG_POST_ID_COL;

		try (var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(query)).mapParams(BlogComment.BLOG_POST_ID_COL, blogPostID)) {

			var resultSet = ps.executeQuery();

			while (resultSet.next()) {
				foundEntities.add(new BlogCommentVMBuilder()
					.setBlogCommentID(resultSet.getString(BlogComment.BLOG_COMMENT_ID_COL))
					.setMessage(resultSet.getString(BlogComment.MESSAGE_COL))
					.setUsername(resultSet.getString(User.USERNAME_COL))
					.setAvatar(resultSet.getString(User.AVATAR_COL))
					.setCreatedDate(resultSet.getTimestamp(BlogComment.CREATED_DATE_COL).toLocalDateTime())
					.build()
				);
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null;
		}

		return foundEntities;
	}
}
