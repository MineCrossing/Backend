package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.BlogPostDTO;

public interface IBlogPostResource extends ICRUDResource<BlogPostDTO, String>{
	BlogPostDTO find(String id);
}
