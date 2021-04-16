package xyz.minecrossing.backend.controller.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogCommentRequest;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogRequest;
import xyz.minecrossing.backend.controller.api.requests.DeleteBlogRequest;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogCommentVM;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogPostPreview;
import xyz.minecrossing.backend.database.models.BlogPost;

import java.util.List;

/**
 * An interface outlining the functionality of the BlogPost endpoint
 *
 * @author Matthew Dodds W18020972
 */
public interface BlogPostAPI {
	/**
	 * A method to get the most recently created blog posts
	 *
	 * @return A list containing the latest blog posts
	 */
	@GetMapping(value = "/blogposts/preview", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<BlogPostPreview>> getPreviewPosts();

	/**
	 * A method to get all blog posts
	 *
	 * @return A list containing all blog posts
	 */
	@GetMapping(value = "/blogposts/previewAll", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<BlogPostPreview>> getAllPreviewPosts();

	/**
	 * A method to create a new blog post
	 *
	 * @param body The details of the blog post to be created
	 * @return True if successful, false otherwise
	 */
	@PostMapping(value = "/blogposts/create", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Boolean> createBlogPost(@RequestBody CreateBlogRequest body);

	/**
	 * A method to delete a blog post
	 *
	 * @param body The details of the blog post to be deleted
	 * @return True if successful, false otherwise
	 */
	@PostMapping(value = "/blogposts/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Boolean> deleteBlogPost(@RequestBody DeleteBlogRequest body);

	/**
	 * A method to lookup a blog post by ID
	 *
	 * @param id The ID of the blog post
	 * @return A blog post if a matching ID is found, null otherwise
	 */
	@GetMapping(value = "/blogposts/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<BlogPost> getBlogPost(@PathVariable String id);

	/**
	 * A method to get all of the blog comments for a given blog post ID
	 *
	 * @param id The blog post ID to lookup comments by
	 * @return A list of blog comments which match the given blog post ID
	 */
	@GetMapping(value = "/blogposts/getComments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<BlogCommentVM>> getBlogPostComments(@PathVariable String id);

	/**
	 * A method to create a new blog comment
	 *
	 * @param body The details of the comment to be created
	 * @return True if successful, false otherwise
	 */
	@PostMapping(value = "/blogposts/createComment", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Boolean> createBlogComment(@RequestBody CreateBlogCommentRequest body);
}
