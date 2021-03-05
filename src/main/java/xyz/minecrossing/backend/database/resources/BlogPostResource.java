package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.BlogPostBuilder;
import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogPostResource;
import xyz.minecrossing.backend.database.models.BlogPost;


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
}
