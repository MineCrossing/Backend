package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.BlogPostBuilder;
import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogPostResource;
import xyz.minecrossing.backend.database.models.BlogPost;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

	@Override
	public BlogPost find(String id) {
		return find(BlogPost.BLOG_POST_ID_COL, id);
	}

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
