package xyz.minecrossing.backend.controller.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogPostPreview;

import java.util.List;

public interface BlogPostAPI {
	@GetMapping(
			value = "/blogposts/preview",
			produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<BlogPostPreview>> getPreviewPosts();

}
