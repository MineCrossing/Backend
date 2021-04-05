package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogCommentRequest;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogRequest;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogCommentVM;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogPostPreview;
import xyz.minecrossing.backend.controller.api.viewmodels.builders.BlogPostPreviewBuilder;
import xyz.minecrossing.backend.database.MineCrossingDB;
import xyz.minecrossing.backend.database.builders.BlogCommentBuilder;
import xyz.minecrossing.backend.database.builders.BlogPostBuilder;
import xyz.minecrossing.backend.database.models.BlogPost;
import xyz.minecrossing.backend.helpers.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class BlogPostAPIController implements BlogPostAPI {
	private final MineCrossingDB db;

	public BlogPostAPIController() {
		db = MineCrossingDB.getInstance();
	}

	private List<BlogPostPreview> toBlogPostPreview(List<BlogPost> blogPosts) {
		if (blogPosts == null)
			return new ArrayList<>();

		return blogPosts
				.stream()
				.filter(b -> !StringUtils.isNullOrEmpty(b.getContent()))
				.map(b -> new BlogPostPreviewBuilder()
						.setBlogPostID(b.getBlogPostID())
						.setAuthor(b.getAuthor())
						.setDate(b.getCreatedDate())
						.setSubtitle(b.getSubtitle())
						.setTitle(b.getTitle())
						.setContent(b.getContent())
						.setPreview(Arrays.stream(b.getContent().trim().split(" ")).limit(120).collect(Collectors.joining(" ")))
						.build()
				).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<List<BlogPostPreview>> getPreviewPosts() {
		var blogPosts = db.BlogPosts.getLatest(3);

		return ResponseEntity.ok(toBlogPostPreview(blogPosts));
	}

	@Override
	public ResponseEntity<List<BlogPostPreview>> getAllPreviewPosts() {
		var blogPosts = db.BlogPosts.findAll();

		return ResponseEntity.ok(toBlogPostPreview(blogPosts).stream().sorted(Comparator.comparing(BlogPostPreview::getDate).reversed()).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<Boolean> createBlogPost(CreateBlogRequest body) {
		if (body == null || StringUtils.anyNullOrEmpty(body.getContent(), body.getSubtitle(), body.getTitle()))
			return ResponseEntity.badRequest().body(false);

		var user = db.Users.find(body.getUserID());

		if (user == null)
			return ResponseEntity.badRequest().body(false);

		if (!db.AccessTokens.validate(body.getToken(), user.getUserID()))
			return ResponseEntity.badRequest().body(false);

		return ResponseEntity.ok(db.BlogPosts.addOrUpdate(new BlogPostBuilder()
				.setBlogPostID(StringUtils.defaultIfEmpty(body.getBlogPostID(), UUID.randomUUID().toString()))
				.setAuthor(user.getUsername())
				//.setCreatedDate(LocalDateTime.now().minusDays(5 + new Random().nextInt(365)))
				.setCreatedDate(LocalDateTime.now())
				.setTitle(body.getTitle())
				.setSubtitle(body.getSubtitle())
				.setContent(body.getContent())
				.setUserID(user.getUserID())
				.build()
		));
	}

	@Override
	public ResponseEntity<BlogPost> getBlogPost(String id) {
		return ResponseEntity.ok(db.BlogPosts.find(id));
	}

	@Override
	public ResponseEntity<List<BlogCommentVM>> getBlogPostComments(String id) {
		 return ResponseEntity.ok(db.BlogComments.findByBlogPostIDWithUsers(id));
	}

	@Override
	public ResponseEntity<Boolean> createBlogComment(CreateBlogCommentRequest body) {
		if (body == null || body.getUserID() < 1 || StringUtils.anyNullOrEmpty(body.getBlogPostID(), body.getMessage()))
			return ResponseEntity.badRequest().body(false);

		var user = db.Users.find(body.getUserID());

		if (user == null)
			return ResponseEntity.badRequest().body(false);

		var blogPost = db.BlogPosts.find(body.getBlogPostID());

		if (blogPost == null)
			return ResponseEntity.badRequest().body(false);

		return ResponseEntity.ok(db.BlogComments.add(new BlogCommentBuilder()
				.setBlogCommentID(UUID.randomUUID().toString())
				//.setCreatedDate(LocalDateTime.now().minusDays(5 + new Random().nextInt(365)))
				.setCreatedDate(LocalDateTime.now())
				.setUserID(user.getUserID())
				.setBlogPostID(blogPost.getBlogPostID())
				.setMessage(body.getMessage())
				.build()
		));
	}
}