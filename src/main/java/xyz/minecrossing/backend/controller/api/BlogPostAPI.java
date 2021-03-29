package xyz.minecrossing.backend.controller.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogCommentRequest;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogRequest;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogCommentVM;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogPostPreview;
import xyz.minecrossing.backend.database.models.BlogPost;

import java.util.List;

public interface BlogPostAPI {
	@GetMapping(value = "/blogposts/preview", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<BlogPostPreview>> getPreviewPosts();

	@GetMapping(value = "/blogposts/previewAll", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<BlogPostPreview>> getAllPreviewPosts();

	@PostMapping(value = "/blogposts/create", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Boolean> createBlogPost(@RequestBody CreateBlogRequest body);

	@GetMapping(value = "/blogposts/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<BlogPost> getBlogPost(@PathVariable String id);

	@GetMapping(value = "/blogposts/getComments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<BlogCommentVM>> getBlogPostComments(@PathVariable String id);

	@PostMapping(value = "/blogposts/createComment", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Boolean> createBlogComment(@RequestBody CreateBlogCommentRequest body);
}
