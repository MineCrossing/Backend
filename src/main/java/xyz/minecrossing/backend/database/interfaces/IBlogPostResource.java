package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.BlogPost;

public interface IBlogPostResource extends ICRUDResource<BlogPost, String>{
	BlogPost find(String id);
}
