package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.BlogPost;

import java.util.List;

public interface IBlogPostResource extends ICRUDResource<BlogPost, String>{
	BlogPost find(String id);

	List<BlogPost> getLatest(int quantity);
}
