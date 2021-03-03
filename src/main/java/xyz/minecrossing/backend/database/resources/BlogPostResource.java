package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.BlogPostDTOBuilder;
import xyz.minecrossing.backend.database.builders.DTOBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogPostResource;
import xyz.minecrossing.backend.database.models.BlogPostDTO;


public class BlogPostResource extends MineCrossingResource<BlogPostDTO, String> implements IBlogPostResource {

	public BlogPostResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_posts");
	}

	@Override
	protected DTOBuilder<BlogPostDTO> modelBuilder() {
		return new BlogPostDTOBuilder();
	}

	@Override
	public BlogPostDTO find(String id) {
		return find(BlogPostDTO.BLOG_POST_ID_COL, id);
	}
}
