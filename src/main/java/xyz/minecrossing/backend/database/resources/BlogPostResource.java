package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.BlogPostBuilder;
import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogPostResource;
import xyz.minecrossing.backend.database.models.BlogPost;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * An implementation of IBlogPostResource
 *
 * @author Matthew Dodds W18020972
 */
public class BlogPostResource extends MineCrossingResource<BlogPost, String> implements IBlogPostResource {

	public BlogPostResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_posts");
	}

	@Override
	protected ModelBuilder<BlogPost> modelBuilder() {
		return new BlogPostBuilder();
	}

	/**
	 * Finds a BlogPost by the given ID
	 *
	 * @param id The ID to search with
	 * @return A matching BlogPost or null if there are no matches
	 */
	@Override
	public BlogPost find(String id) {
		return find(BlogPost.BLOG_POST_ID_COL, id);
	}

	/**
	 * Returns the latest number of BlogPosts by a given quantity
	 *
	 * @param quantity The number of posts to return
	 * @return The requested number of posts
	 */
	@Override
	public List<BlogPost> getLatest(int quantity) {
		var blogPosts = new ArrayList<BlogPost>();

		try (var ps = getNamedParamStatement(
				queryBuilder()
						.select()
						.orderBy(true, BlogPost.CREATED_DATE_COL)
						.limit(quantity)
						.build()
		)) {
			var rs = ps.executeQuery();

			while (rs.next())
				blogPosts.add(new BlogPostBuilder().fromResultSet(rs).build());

			rs.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null;
		}

		return blogPosts;
	}
}
